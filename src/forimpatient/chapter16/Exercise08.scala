package forimpatient.chapter16

import scala.xml.NodeSeq

/**
  * Created by Iryna Kharaborkina on 8/23/16. 
  *
  * Solution to the Chapter 16 Exercise 08 'Scala for the Impatient' by Horstmann C.S.
  * Write a function that takes a dl element and turns it into a Map[String, String].
  * This function should be the inverse of the function in the preceding exercise,
  * provided all dt children are distinct.
  */
object Exercise08 extends App {
  println("Chapter 16 Exercise 08")

  def parseList(xml: NodeSeq) = (xml \\ "dt").map(_.child.text) zip (xml \\ "dd").map(_.child.text) toMap

  println(parseList(<dl><dt>A</dt><dd>1</dd><dt>B</dt><dd>2</dd></dl>))
}
