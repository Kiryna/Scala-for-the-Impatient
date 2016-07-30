package forimpatient.chapter04

import scala.io.Source

/**
  * Created by Iryna Kharaborkina on 7/29/16. 
  *
  * Solution to the Chapter 04 Exercise 03 'Scala for the Impatient' by Horstmann C.S.
  *
  * Repeat the preceding exercise with an immutable map.
  */
object Exercise03 extends App {
  println("Chapter 04 Exercise 03")

  var m = Map[String, Int]()
  Source.fromFile("myfile.txt").getLines.flatMap(_.split("\\s+")).foreach(w => m += (w -> (m.getOrElse(w, -0) + 1)))
  println(m)
}
