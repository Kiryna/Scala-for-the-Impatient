package forimpatient.chapter07

/**
  * Created by Iryna Kharaborkina on 8/3/16.
  *
  * Solution to the Chapter 07 Exercise 03 'Scala for the Impatient' by Horstmann C.S.
  *
  * Write a package random with functions nextInt(): Int, nextDouble(): Double, and setSeed(seed: Int):Unit.
  * To generate random numbers, use the linear congruential generator
  *     next = (previous × a + b) mod 2**n,
  * where a = 1664525, b = 1013904223, n = 32, and the inital value of previous is seed.
  */
object Exercise03 extends App {
  println("Chapter 07 Exercise 03")

  import random._

  setSeed(10)
  println(nextDouble())
  println(nextInt())
}


package object random {
  import scala.math._

  val a = 1664525
  val b = 1013904223
  val n = 32
  var previous = 0.0

  def nextInt() = {
    nextDouble().toInt
  }

  def nextDouble() = {
    previous = (previous * a + b) % pow(2, n)
    previous
  }

  def setSeed(seed: Int): Unit = {
    previous = seed
  }
}

