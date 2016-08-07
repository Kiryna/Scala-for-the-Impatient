package forimpatient.chapter09

import scala.io.Source

/**
  * Created by Iryna Kharaborkina on 8/7/16. 
  *
  * Solution to the Chapter 09 Exercise 07 'Scala for the Impatient' by Horstmann C.S.
  *
  * Write a Scala program that reads a text file and prints all tokens in the file that are not floating-point
  * numbers. Use a regular expression.
  */
object Exercise07 extends App {
  println("Chapter 09 Exercise 07")

  val path = "src/forimpatient/chapter09/Exercise05.txt"
  val nonFloatPoint = """^(?!([+-])?([0-9]*[.])?[0-9E+-]+).*""".r
  for (word <- nonFloatPoint.findAllIn(Source.fromFile(path, "UTF-8").mkString)) println(word)

}
