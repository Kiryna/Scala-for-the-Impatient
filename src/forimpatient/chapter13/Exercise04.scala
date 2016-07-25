package forimpatient.chapter13

/**
  * Created by Iryna Kharaborkina on 7/25/16. 
  *
  * Solution to the Chapter 13 Exercise 04 'Scala for the Impatient' by Horstmann C.S.
  *
  * Write a function that receives a collection of strings and a map from strings to integers. Return a
  * collection of integers that are values of the map corresponding to one of the strings in the
  * collection. For example, given Array("Tom", "Fred", "Harry") and Map("Tom" -> 3, "Dick" -> 4, "Harry" -> 5),
  * return Array(3, 5). Hint: Use flatMap to combine the Option values returned by get.
  */
object Exercise04 extends App {
  println(mapCollections(Array("Tom", "Fred", "Harry"), Map("Tom" -> 3, "Dick" -> 4, "Harry" -> 5)))

//  def mapCollections(s: Seq[String], m: Map[String, Int]) = (for (a <- s) yield m.getOrElse(a, Nil)).filter(_ != Nil)
  def mapCollections(s: Seq[String], m: Map[String, Int]) = s.flatMap(m.get(_))
}
