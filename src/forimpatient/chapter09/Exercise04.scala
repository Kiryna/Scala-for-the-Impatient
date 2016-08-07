package forimpatient.chapter09

import scala.io.Source

/**
  * Created by Iryna Kharaborkina on 8/7/16. 
  *
  * Solution to the Chapter 09 Exercise 04 'Scala for the Impatient' by Horstmann C.S.
  *
  * Write a Scala program that reads a text file containing only floating-point numbers.
  * Print the sum, average, maximum, and minimum of the numbers in the file.
  */
object Exercise04 extends App {
  println("Chapter 09 Exercise 04")

  val path = "src/forimpatient/chapter09/Exercise04.txt"
  val numbers = for (n <- Source.fromFile(path).mkString.split("\\s+")) yield n.toDouble
  println("sum = " + numbers.sum)
  println("max = " + numbers.max)
  println("min = " + numbers.min)

}
