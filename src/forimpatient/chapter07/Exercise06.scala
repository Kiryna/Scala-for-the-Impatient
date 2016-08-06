package forimpatient.chapter07

/**
  * Created by Iryna Kharaborkina on 8/6/16. 
  *
  * Solution to the Chapter 07 Exercise 06 'Scala for the Impatient' by Horstmann C.S.
  *
  * Write a program that copies all elements from a Java hash map into a Scala hash map.
  * Use imports to rename both classes.
  */
object Exercise06 extends App {
  println("Chapter 07 Exercise 06")

  import java.util.{HashMap => JavaHashMap}
  import scala.collection.mutable.{HashMap => ScalaHashMap}
  import scala.collection.JavaConversions.mapAsScalaMap

  val jm = new JavaHashMap[Int, String]()
  jm put (1, "First")
  jm put (2, "Second")

  val b = copyMap(jm)
  println(b.mkString(" and "))

  def copyMap[K, V](jMap: JavaHashMap[K, V]) = {
    val sMap = new ScalaHashMap[K, V]
    for (pair <- jMap) sMap += pair
    sMap
  }
}
