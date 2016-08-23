package forimpatient.chapter16

import scala.io.Source
import scala.xml.parsing.XhtmlParser

/**
  * Created by Iryna Kharaborkina on 8/19/16. 
  *
  * Solution to the Chapter 16 Exercise 05 'Scala for the Impatient' by Horstmann C.S.
  *
  * Print the names of all images in an XHTML file. That is, print all src attribute values inside img elements.
  */
object Exercise05 extends App {
  println("Chapter 16 Exercise 05")

  val xhtml = XhtmlParser(Source.fromURL("https://www.w3.org"))
  (xhtml \\ "img" \\ "@src").foreach(println)
}
