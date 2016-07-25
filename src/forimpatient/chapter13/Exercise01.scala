package forimpatient.chapter13

import scala.collection.mutable.{Map, SortedSet}

/**
  * Created by Iryna Kharaborkina on 7/25/16. 
  *
  * Solution to the Chapter 13 Exercise 01 'Scala for the Impatient' by Horstmann C.S.
  *
  * Write a function that, given a string, produces a map of the indexes of all characters. For
  * example, indexes("Mississippi") should return a map associating 'M' with the set {0}, 'i' with the set
  * {1, 4, 7, 10}, and so on. Use a mutable map of characters to mutable sets. How can you ensure
  * that the set is sorted?
  */
object Exercise01 extends App {
  println("Chapter 13 Exercise 01")
  println(indexes("Missisipi"))

  def indexes(str: String) = {
    val m = Map[Char, SortedSet[Int]]()
    for (s <-  str.zipWithIndex) {
      m(s._1) = m.getOrElse(s._1, SortedSet[Int]()) + s._2
    }
    m
  }
}
