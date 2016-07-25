package forimpatient.chapter02

import scala.collection.immutable.StringOps

/**
  * Created by Iryna Kharaborkina on 7/25/16. 
  *
  * Solution to the Chapter 02 Exercise 08 'Scala for the Impatient' by Horstmann C.S.
  *
  * Write a function product(s : String) that computes the product, as described in the preceding
  * exercises.
  */
object Exercise08 extends App {
  println("Chapter 02 Exercise 08")
  val prodOne = product("Hello")
  assert(prodOne == 9415087488L)
  println(prodOne)

  val prodTwo = productWithoutLoop("Hello")
  assert(prodTwo == 9415087488L)
  println(prodTwo)

  def product(s: String) = {var prod = 1L; for (ch <- s) prod *= ch; prod}

  def productWithoutLoop(s: String) = s.map(_.toLong).product

}
