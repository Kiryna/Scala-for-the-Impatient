package forimpatient.chapter02

/**
  * Created by Iryna Kharaborkina on 7/25/16. 
  *
  * Solution to the Chapter 02 Exercise 07 'Scala for the Impatient' by Horstmann C.S.
  *
  * Without loop compute the product of the Unicode codes of all letters in a string. For
  * example, the product of the characters in "Hello" is 9415087488L. (Hint: Look at the StringOps Scaladoc.)
  */
object Exercise07 extends App {
  println("Chapter 02 Exercise 07")
  val prod = "Hello".map(_.toLong).product
  assert(prod == 9415087488L)
  println(prod)
}
