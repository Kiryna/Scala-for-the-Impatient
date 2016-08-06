package forimpatient.chapter07

import java.util

/**
  * Created by Iryna Kharaborkina on 8/6/16. 
  *
  * Solution to the Chapter07 Exercise 07 'Scala for the Impatient' by Horstmann C.S.
  *
  * Write a program that copies all elements from a Java hash map into a Scala hash map.
  * Move all imports into the innermost scope possible.
  */
object Exercise07 extends App {
  println("Chapter07 Exercise 07")

  val jm = new java.util.HashMap[Int, String]()
  jm put (1, "First")
  jm put (2, "Second")

  val b = copyMap(jm)
  println(b.mkString(" and "))


  def copyMap[K, V](jMap: java.util.HashMap[K, V]) = {
    val sMap = new scala.collection.mutable.HashMap[K, V]
    val iterator: util.Iterator[K] = jMap.keySet().iterator()
    while (iterator.hasNext) {val k = iterator.next();  sMap += (k -> jMap.get(k))}
    sMap
  }
}
