package forimpatient.chapter02

import scala.annotation.tailrec

/**
  * Created by Iryna Kharaborkina on 7/25/16. 
  *
  * Solution to the Chapter 02 Exercise 10 'Scala for the Impatient' by Horstmann C.S.
  *
  * Write a function that computes x**n, where n is an integer. Use the following recursive definition:
  *     • x**n = y2 if n is even and positive, where y = x**(n / 2).
  *     • x**n = x**x(n – 1) if n is odd and positive.
  *     • x**0 = 1.
  *     • xn = 1 / x**(–n) if n is negative.
  * Don’t use a return statement.
  */
object Exercise10 extends App {
  println("Chapter 02 Exercise 09")
  val powOne: Double = pow(2, 2)
  assert(powOne == math.pow(2, 2))
  println(powOne)

  val powTwo: Double = pow(0.5, 2)
  assert(powTwo == math.pow(0.5, 2))
  println(powTwo)

  val powThree: Double = pow(2, 128)
  assert(powThree == math.pow(2, 128))
  println(powThree)

  def pow(x: Double, n: Int): Double = {
    if (n == 0) 1
    else if (n < 0) 1 / pow(x, n)
    else if (n % 2 == 0) {val res = pow(x, n / 2); res * res}
    else x * pow(x, n - 1)
  }
}