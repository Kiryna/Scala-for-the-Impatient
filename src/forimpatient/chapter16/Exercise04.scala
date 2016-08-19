package forimpatient.chapter16

import scala.io.Source
import scala.xml.parsing.XhtmlParser

/**
  * Created by Iryna Kharaborkina on 8/17/16. 
  *
  * Solution to the Chapter 16 Exercise 04 'Scala for the Impatient' by Horstmann C.S.
  *
  * Read an XHTML file and print all img elements that don’t have an alt attribute
  */
object Exercise04 extends App {
  println("Chapter 16 Exercise 04")

  val xhtml = XhtmlParser(Source.fromURL("https://www.w3.org"))
  println("alt is defined:")
  (xhtml \\ "img").filter(_.attribute("alt").isDefined).foreach(println)
  println("\nalt is not defined:")
  (xhtml \\ "img").filterNot(_.attribute("alt").isDefined).foreach(println)
}
