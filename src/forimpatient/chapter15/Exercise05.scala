package forimpatient.chapter15

import scala.io.Source

/**
  * Created by Iryna Kharaborkina on 8/13/16. 
  *
  * Solution to the Chapter 15 Exercise 05 'Scala for the Impatient' by Horstmann C.S.
  *
  * Write a Scala method that returns a string containing all lines of a file. Call it from Java.
  */
object Exercise05 {
  println("Chapter 15 Exercise 05")

  def getFileLines(path: String) = Source.fromFile(path).mkString
}
