package forimpatient.chapter12

/**
  * Created by Iryna Kharaborkina on 8/9/16. 
  *
  * Solution to the Chapter 12 Exercise 03 'Scala for the Impatient' by Horstmann C.S.
  *
  * Implement the factorial function using to and reduceLeft, without a loop or recursion.
  */
object Exercise03 extends App {
  println("Chapter 12 Exercise 03")

  println(factorial(5))
  println(factorial(0))

  def factorial(n: Int) = if (n == 0) 1 else (1 to n) reduceLeft {(x: Int, y: Int) => x * y}
}
