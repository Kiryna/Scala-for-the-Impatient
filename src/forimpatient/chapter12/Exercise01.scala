package forimpatient.chapter12

/**
  * Created by Iryna Kharaborkina on 7/24/16.
  *
  * Solution to the Chapter 12 Exercise 01 'Scala for the Impatient' by Horstmann C.S.
  *
  * Write a function values(fun: (Int) => Int, low: Int, high: Int) that yields a collection of function
  * inputs and outputs in a given range. For example, values(x => x * x, -5, 5) should produce a
  * collection of pairs (-5, 25), (-4, 16), (-3, 9), . . ., (5, 25).
  */
object Exercise01 extends App {
  println("Chapter 12 Exercise 01")

  def values(fun: (Int) => Int, low: Int, high: Int) = for (el <- low to high) yield (el, fun(el))

  println(values(x => x * x, -5, 5))
  println(values(x => -x, -5, 5))
}
