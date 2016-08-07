package forimpatient.chapter09

import scala.io.Source

/**
  * Created by Iryna Kharaborkina on 8/7/16. 
  *
  * Solution to the Chapter 09 Exercise 03 'Scala for the Impatient' by Horstmann C.S.
  *
  * Write a Scala code snippet that reads a file and prints all words with more than 12 characters to the console.
  * Extra credit if you can do this in a single line.
  */
object Exercise03 extends App {
  println("Chapter 09 Exercise 03")

  for (elem <- Source.fromFile("LICENSE").mkString.split("\\s+").filter(_.length > 12)) println(elem)
}
