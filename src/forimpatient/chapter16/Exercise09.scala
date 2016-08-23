package forimpatient.chapter16

import scala.xml.{Attribute, Elem, Node, Null}
import scala.xml.transform.{RewriteRule, RuleTransformer}

/**
  * Created by Iryna Kharaborkina on 8/23/16. 
  *
  * Solution to the Chapter 16 Exercise 09 'Scala for the Impatient' by Horstmann C.S.
  *
  * Transform an XHTML document by adding an alt="TODO" attribute to all img elements without an alt attribute,
  * preserving everything else.
  */
object Exercise09 extends App {
  println("Chapter 16 Exercise 09")

  val doc = <html><body><img src="scala.jpg" alt="Scala logo"/><img
    src="python.jpg"/><img src="java.jpg" alt="Java logo"/><img src="cpp.jpg"/></body></html>

  val rule = new RewriteRule {
    override def transform(n: Node): Seq[Node] = n match {
      case im @ <img/> if im.attribute("alt").isEmpty => im.asInstanceOf[Elem] % Attribute(null, "alt", "TODO", Null)
      case _ => n
    }
  }
  val docWithTODO = new RuleTransformer(rule).transform(doc)

  println(doc)
  println(docWithTODO)
}
