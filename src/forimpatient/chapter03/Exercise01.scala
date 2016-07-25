package forimpatient.chapter03

import scala.util.Random

/**
  * Created by Iryna Kharaborkina on 7/25/16. 
  *
  * Solution to the Chapter 03 Exercise 01 'Scala for the Impatient' by Horstmann C.S.
  *
  * Write a code snippet that sets a to an array of n random integers between 0 (inclusive) and n (exclusive).
  */
object Exercise01 extends App {
  println("Chapter 03 Exercise 01")
  val str = (a: Array[Int]) => a.mkString("[", ", ", "]")
  println(str(randomArray(10)))
  println(str(randomArray(20)))
  println(str(randomArray(0)))
  println(str(randomArray(-5)))

  def randomArray(n: Int) = (for (i <- 0 until  n) yield Random.nextInt(n)).toArray
}
