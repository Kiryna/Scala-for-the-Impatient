package forimpatient.chapter04

import java.util.TreeMap
import scala.io.Source
import scala.collection.JavaConversions.mapAsScalaMap

/**
  * Created by Iryna Kharaborkina on 7/30/16. 
  *
  * Solution to the Chapter 04 Exercise 05 'Scala for the Impatient' by Horstmann C.S.
  *
  * Repeat the preceding exercise with a java.util.TreeMap that you adapt to the Scala API.
  */
object Exercise05 extends App {
  println("Chapter 04 Exercise 05")

  var m = new TreeMap[String, Int]()
  Source.fromFile("myfile.txt").getLines.flatMap(_.split("\\s+")).foreach(w => m(w) = m.getOrElse(w, 0) + 1)
  println(m)

}
