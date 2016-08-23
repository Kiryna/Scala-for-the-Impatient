package forimpatient.chapter16

import scala.xml._
import scala.xml.dtd.{DocType, PublicID}
import scala.xml.transform.{RewriteRule, RuleTransformer}

/**
  * Created by Iryna Kharaborkina on 8/23/16. 
  *
  * Solution to the Chapter 16 Exercise 10 'Scala for the Impatient' by Horstmann C.S.
  *
  * Write a function that reads an XHTML document, carries out the transformation of the preceding exercise,
  * and saves the result. Be sure to preserve the DTD and any CDATA sections.
  */
object Exercise10 extends App {
  println("Chapter 16 Exercise 10")

  val doc = <html><head><title/></head><body><div><img src="scala.jpg" alt="Scala logo"/><img
    src="python.jpg"/><img src="java.jpg" alt="Java logo"/><img src="cpp.jpg"/></div><div><script type="text/javascript">{
    PCData("""if (temp < 0) alert("Cold!")""")}</script></div></body></html>

  addTODOs(doc)

  def addTODOs(xml: Node) = {
    val rule = new RewriteRule {
      override def transform(n: Node): Seq[Node] = n match {
        case im @ <img/> if im.attribute("alt").isEmpty => im.asInstanceOf[Elem] % Attribute(null, "alt", "TODO", Null)
        case _ => n
      }
    }
    val withTODO = new RuleTransformer(rule).apply(xml)

    val filePath = "src/forimpatient/chapter16/doc.xhtml"
    XML.save(filePath, withTODO, enc = "UTF-8", xmlDecl = true, doctype =
      DocType("html", PublicID("-//W3C//DTD XHTML 1.0 Strict//EN", "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd"),
      Nil))
  }

}
