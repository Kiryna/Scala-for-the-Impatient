package forimpatient.chapter02

/**
  * Created by Iryna Kharaborkina on 7/25/16. 
  *
  * Solution to the Chapter 02 Exercise 06 'Scala for the Impatient' by Horstmann C.S.
  *
  * Write a for loop for computing the product of the Unicode codes of all letters in a string. For
  * example, the product of the characters in "Hello" is 9415087488L.
  */
object Exercise06 extends App {
  println("Chapter 02 Exercise 06")
  var prod = 1L
  for (ch <- "Hello") prod *= ch
  assert(prod == 9415087488L)
  println(prod)
}