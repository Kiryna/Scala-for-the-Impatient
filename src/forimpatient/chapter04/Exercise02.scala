package forimpatient.chapter04

import scala.collection.mutable.Map
import scala.io.Source

/**
  * Created by Iryna Kharaborkina on 7/29/16. 
  *
  * Solution to the Chapter 04 Exercise 02 'Scala for the Impatient' by Horstmann C.S.
  *
  * Write a program that reads words from a file. Use a mutable map to count how often each word appears.
  * To read the words, simply use a java.util.Scanner:
  */
object Exercise02 extends App {
  println("Chapter 04 Exercise 02")

  val m = Map[String, Int]()
  Source.fromFile("myfile.txt").getLines.flatMap(_.split("\\s+")).foreach(w => m(w) = m.getOrElse(w, 0) + 1)
  println(m)
}
