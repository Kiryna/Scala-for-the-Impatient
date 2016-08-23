package forimpatient.chapter16

import scala.io.Source
import scala.xml.parsing.XhtmlParser

/**
  * Created by Iryna Kharaborkina on 8/22/16. 
  *
  * Solution to the Chapter 16 Exercise 06 'Scala for the Impatient' by Horstmann C.S.
  *
  * Read an XHTML file and print a table of all hyperlinks in the file, together with their URLs.
  * That is, print the child text and the href attribute of each a element.
  */
object Exercise06 extends App {
  println("Chapter 16 Exercise 06")

  val xhtml = XhtmlParser(Source.fromURL("https://www.w3.org"))

  (xhtml \\ "a").filter(_.attribute("href").isDefined).foreach(s => println(s.child + " -> " +  s.attribute("href").mkString))
}
