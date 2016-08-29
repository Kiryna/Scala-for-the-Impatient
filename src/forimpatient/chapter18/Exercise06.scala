package forimpatient.chapter18

import scala.math.abs

/**
  * Created by Iryna Kharaborkina on 8/29/16. 
  *
  * Solution to the Chapter 18 Exercise 06 'Scala for the Impatient' by Horstmann C.S.
  *
  * The Either type in the Scala library can be used for algorithms that return either a result
  * or some failure information. Write a function that takes two parameters: a sorted array of integers
  * and an integer value. Return either the index of the value in the array or the index of the element
  * that is closest to the value. Use an infix type as the return type.
  */
object Exercise06 extends App {
  println("Chapter 18 Exercise 06")

  private val array = (0 to (100, 2)).toArray
  private val value = 5
  println(getClosest(array, value))

  def getClosest(arr: Array[Int], value: Int): Int Either Int = arr.map((x: Int) => abs(value - x))
        .zipWithIndex.minBy(_._1) match {
    case (0, i) => new Left(i)
    case (_, i) => new Right(i)
  }
}
