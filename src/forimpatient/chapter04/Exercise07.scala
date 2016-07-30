package forimpatient.chapter04


import scala.collection.JavaConversions.propertiesAsScalaMap
import scala.collection.Map
/**
  * Created by Iryna Kharaborkina on 7/30/16.
  *
  * Solution to the Chapter04 Exercise 07 'Scala for the Impatient' by Horstmann C.S.
  *
  * Print a table of all Java properties, like this:
  *       java.runtime.name         | Java(TM) SE Runtime Environment
  *       sun.boot.library.path     | /home/apps/jdk1.6.0_21/jre/lib/i386
  */
object Exercise07 extends App {
  println("Chapter 04 Exercise 07")

  val props: Map[String, String] = System.getProperties
  val maxLength = props.keys.maxBy(_.length).length
  for (p <- props) println(p._1 + " " * (maxLength - p._1.length) + " | " + p._2)
}
