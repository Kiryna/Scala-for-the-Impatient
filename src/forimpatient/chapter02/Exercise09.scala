package forimpatient.chapter02

/**
  * Created by Iryna Kharaborkina on 7/25/16. 
  *
  * Solution to the Chapter 02 Exercise 09 'Scala for the Impatient' by Horstmann C.S.
  *
  * Write a function product(s : String) that computes the product, as described in the preceding
  * exercises. Make it a recursive function.
  */
object Exercise09 extends App {
  println("Chapter 02 Exercise 09")
  val prodOne = product("Hello")
  assert(prodOne == 9415087488L)
  println(prodOne)

  def product(s : String): Long = if (s.isEmpty) 1L else s.head * product(s.tail)
}
