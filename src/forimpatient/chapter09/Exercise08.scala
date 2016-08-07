package forimpatient.chapter09

import scala.io.Source

/**
  * Created by Iryna Kharaborkina on 8/7/16. 
  *
  * Solution to the Chapter 09 Exercise 08 'Scala for the Impatient' by Horstmann C.S.
  *
  * Write a Scala program that prints the src attributes of all img tags of a web page.
  * Use regular expressions and groups.
  */
object Exercise08 extends App {
  println("Chapter 09 Exercise 08")

  val webPath = "http://www.scala-lang.org/"

  val imgSrcPattern = """(img\s+src)="([0-9a-zA-Z.:_\-/]+)"""".r
  val web: String = Source.fromURL(webPath).mkString
  for (imgSrcPattern(img, src) <- imgSrcPattern.findAllIn(web)) println(webPath + src)
}
