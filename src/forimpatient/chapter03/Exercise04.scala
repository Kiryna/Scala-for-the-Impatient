package forimpatient.chapter03

/**
  * Created by Iryna Kharaborkina on 7/26/16. 
  *
  * Solution to the Chapter 03 Exercise 04 'Scala for the Impatient' by Horstmann C.S.
  *
  * Given an array of integers, produce a new array that contains all positive values of the original array,
  * in their original order, followed by all values that are zero or negative, in their original order.
  */
object Exercise04 extends App {
  println("Chapter 03 Exercise 04")
  val a = Array(5, -2, 3, 4, 0, 7, 1, -5, 9, -7, 0, 4, -4, -9, 1)
  println(a.mkString(", "))

  val b = a.filter(_ > 0) ++ a.filter(_ <= 0)
  println(b.mkString(", "))
}
