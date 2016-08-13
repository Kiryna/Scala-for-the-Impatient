package forimpatient.chapter15

import scala.annotation.varargs

/**
  * Created by Iryna Kharaborkina on 8/13/16. 
  *
  * Solution to the Chapter 15 Exercise 04 'Scala for the Impatient' by Horstmann C.S.
  *
  * Write a Scala method sum with variable integer arguments that returns the sum of its arguments. Call it from Java.
  */
object Exercise04 {
  println("Chapter 15 Exercise 04")

  @varargs def sum(a: Int*) =a.sum
}
