package forimpatient.chapter11

import scala.math.abs

/**
  * Created by Iryna Kharaborkina on 8/8/16. 
  *
  * Solution to the Chapter 11 Exercise 04 'Scala for the Impatient' by Horstmann C.S.
  *
  * Implement a class Money with fields for dollars and cents. Supply +, - operators as well as comparison operators
  * == and `<`. For example, Money(1, 75) + Money(0, 50) `==` Money(2, 25) should be true.
  * Should you also supply * and / operators? Why or why not?
  **/
object Exercise04 extends App {
  println("Chapter 11 Exercise 04")

  val a = Money(10, 115)
  val b: Money = Money(2, 95)
  println(a)
  println(a + b)
  println(a - b)
  println(b - a)
  println(a < b)
  println(b < a)
  println(Money(1, 75) + Money(0, 50) == Money(2, 25))

  class Money(dollars: Int, cents: Int) {
    private val sign = if (dollars * 100 + cents < 0) -1 else +1
    val d: Int = abs(dollars * 100 + cents) / 100
    val c: Int = abs(dollars * 100 + cents) % 100

    override def toString = (if (sign < 0) "-$" else "$") + abs(d) + ","  + c

    def +(other: Money) = new Money(d + other.d, c + other.c)
    def -(other: Money): Money = new Money(d - other.d, c - other.c)
    def ==(other: Money) = (d * 100 + c) * sign == (other.d * 100 + other.c) * other.sign
    def <(other: Money) = (d * 100 + c) * sign < (other.d * 100 + other.c) * other.sign
    def >(other: Money) = !(this < other)
  }

  object Money{
    def apply(dollars: Int, cents: Int) = new Money(dollars, cents)
  }
}
