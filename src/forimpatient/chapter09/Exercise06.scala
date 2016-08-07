package forimpatient.chapter09

import scala.io.Source

/**
  * Created by Iryna Kharaborkina on 8/7/16. 
  *
  * Solution to the Chapter 09 Exercise 06 'Scala for the Impatient' by Horstmann C.S.
  *
  * Make a regular expression searching for quoted strings "like this, maybe with \" or \\"
  * in a Java or C++ program. Write a Scala program that prints out all such strings in a source file.
  */
object Exercise06 extends App {
  println("Chapter 09 Exercise 06")

  val path = "src/forimpatient/chapter05/Exercise09.java"
  val quotedPattern = """"([0-9a-zA-Z_/\{} \\"]+)"""".r
  for (line <- quotedPattern.findAllIn(Source.fromFile(path).mkString)) println(line)
}
