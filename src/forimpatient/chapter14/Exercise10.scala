package forimpatient.chapter14

import math.sqrt
/**
  * Created by Iryna Kharaborkina on 8/12/16. 
  *
  * Solution to the Chapter 14 Exercise 10 'Scala for the Impatient' by Horstmann C.S.
  *
  * Write a function that composes two functions of type Double => Option[Double], yielding another function
  * of the same type. The composition should yield None if either function does. For example,
  *       def f(x: Double) = if (x >= 0) Some(sqrt(Double)) else None
  *       def g(x: Double) = if (x != 1) Some(1 / (x - 1)) else None
  *       val h = compose(f, g)
  *  Then h(2) is Some(1), and h(1) and h(0) are None.
  */
object Exercise10 extends App {
  println("Chapter 14 Exercise 10")

  val h = compose(f, g)
  println(h(0))
  println(h(1))
  println(h(2))

  def f(x: Double) = if (x >= 0) Some(sqrt(x)) else None
  def g(x: Double) = if (x != 1) Some(1 / (x - 1)) else None

  def compose(first: (Double) => Option[Double], second: (Double) => Option[Double]) = (x: Double) => {
    val s = second(x)
    if (s.isDefined) first(s.get) else None
  }

}
