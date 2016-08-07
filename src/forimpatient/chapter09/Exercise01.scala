package forimpatient.chapter09

import scala.io.Source

/**
  * Created by Iryna Kharaborkina on 8/6/16. 
  *
  * Solution to the Chapter 09 Exercise 01 'Scala for the Impatient' by Horstmann C.S.
  *
  * Write a Scala code snippet that reverses the lines in a file (making the last line the first one, and so on).
  */
object Exercise01 extends App {
  println("Chapter 09 Exercise 01")

  val path = "LICENSE"
  Source.fromFile(path).getLines().toArray.reverse.foreach(println(_))
}
