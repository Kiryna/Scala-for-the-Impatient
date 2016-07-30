package forimpatient.chapter04

import scala.collection.SortedMap
import scala.io.Source

/**
  * Created by Iryna Kharaborkina on 7/30/16. 
  *
  * Solution to the Chapter 04 Exercise 04 'Scala for the Impatient' by Horstmann C.S.
  *
  * Repeat the preceding exercise with a sorted map, so that the words are printed in sorted order.
  */
object Exercise04 extends App {
  println("Chapter 04 Exercise 04")

  var m = SortedMap[String, Int]()
  Source.fromFile("myfile.txt").getLines.flatMap(_.split("\\s+")).foreach(w => m += (w -> (m.getOrElse(w, -0) + 1)))
  println(m)
}
