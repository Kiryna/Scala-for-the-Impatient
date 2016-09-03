package forimpatient.chapter19

import scala.util.parsing.combinator.RegexParsers
import scala.xml.{Attribute, MetaData, Node, NodeBuffer, NodeSeq, Null, Text, TopScope, UnprefixedAttribute, Elem => XmlElem}

/**
  * Created by Iryna Kharaborkina on 9/3/16. 
  *
  * Solution to the Chapter 19 Exercise 05 'Scala for the Impatient' by Horstmann C.S.
  *
  * Write a parser that parses a subset of XML. Handle tags of the form <ident> ... </ident> or <ident/>.
  * Tags can be nested. Handle attributes inside tags. Attribute values can be delimited by single or double quotes.
  * You don’t need to deal with character data (that is, text inside tags or CDATA sections).
  * Your parser should return a Scala XML Elem value. The challenge is to reject mismatched tags. Hint: into, accept.
  */
object Exercise05 extends App {
  println("19 Exercise 05")

  val parser = new XmlParser
  val XML = "<html><head><title>Fred's Memoirs!</title></head>" +
    "<body><a href=\"http://scala-lang.org\">The <em>Scala</em> language?</a></body></html>"
  val result = parser.parseAll(parser.sequence, XML)
  if (result.successful) println(result.get)

  class XmlParser extends RegexParsers {
    val label = "[a-z]+".r
    val attr = """[a-z0-9 .:\/-]+""".r
    val text = """[a-zA-Z0-9 .:,!?'\/-]+""".r

    def sequence: Parser[NodeSeq] = rep(tag | empty) ^^ { r => (new NodeBuffer ++ r).filter(_ != null)}

    def tag: Parser[Node] = ("<" ~> label ~ attributes <~ ">") ~ sequence ~ textWithTags ~ ("</" ~> label <~ ">") ^^ {
      case tagOpen ~ attr ~ beginning ~ ending ~ tagClose if tagOpen == tagClose =>
        XmlElem(null, tagOpen, attr, TopScope, true, beginning ++ ending: _*)
      case _ => null
    }

    def empty: Parser[Node] = "<" ~> label <~ "/>" ^^ {
      t  => XmlElem(null, t, Null, TopScope, minimizeEmpty = true)
    }

    def textWithTags: Parser[NodeSeq] = rep(rowText ~ sequence) ^^ {
      r => {val buf = new NodeBuffer; for (el <- r) {buf += el._1; buf ++= el._2 }; buf}
    }

    def rowText: Parser[Node] = text ^^ {t => Text(t)}

    def attributes: Parser[MetaData] = rep(label ~ ("=\"" ~> attr <~"\"" | "=\'" ~> attr <~"\'" )) ^^ {
      a => a.foldRight(Null: MetaData)((pair, next) => Attribute(null, pair._1, pair._2, next))
    }
  }
}
