package forimpatient.chapter11

import scala.math._

/**
  * Created by Iryna Kharaborkina on 8/8/16. 
  *
  * Solution to the Chapter 11 Exercise 03 'Scala for the Impatient' by Horstmann C.S.
  *
  * Implement the Fraction class with operations + - * /. Normalize fractions, for example turning 15/–6 into –5/2.
  * Divide by the greatest common divisor, like this:
  *     class Fraction(n: Int, d: Int) {
  *       private val num: Int = if (d == 0) 1 else n * sign(d) / gcd(n, d);
  *       private val den: Int = if (d == 0) 0 else d * sign(d) / gcd(n, d);
  *       override def toString = num + "/" + den
  *       def sign(a: Int) = if (a > 0) 1 else if (a < 0) -1 else 0
  *       def gcd(a: Int, b: Int): Int = if (b == 0) abs(a) else gcd(b, a % b)
  *       ...
  *     }
  */
object Exercise03 extends App {
  println("Chapter 11 Exercise 03")

  val a = Fraction(1, 2)
  val b = Fraction(4, 6)

  println(a)
  println(b)

  println(a + b)
  println(a - b)
  println(a * b)
  println(a / b)

  class Fraction(n: Int, d: Int) {
    private val num: Int = if (d == 0) 1 else n * sign(d) / gcd(n, d)
    private val den: Int = if (d == 0) 0 else d * sign(d) / gcd(n, d)

    def +(other: Fraction) = new Fraction(num * other.den + other.num * den, den * other.den)
    def -(other: Fraction) = new Fraction(num * other.den - other.num * den, den * other.den)
    def *(other: Fraction) = new Fraction(num * other.num, den * other.den)
    def /(other: Fraction) = new Fraction(num * other.den, den * other.num)

    override def toString = num + "/" + den
    def sign(a: Int) = if (a > 0) 1 else if (a < 0) - 1 else 0
    def gcd(a: Int, b: Int):Int = if (b == 0) abs(a) else gcd (b, a % b)
  }

  object Fraction {
    def apply(n: Int, d: Int) = new Fraction(n, d)
  }
}
