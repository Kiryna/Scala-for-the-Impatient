package forimpatient.chapter12

/**
  * Created by Iryna Kharaborkina on 8/9/16. 
  *
  * Solution to the Chapter 12 Exercise 04 'Scala for the Impatient' by Horstmann C.S.
  *
  * The previous implementation needed a special case when n < 1. Show how you can avoid this with foldLeft.
  * (Look at the Scaladoc for foldLeft. It’s like reduceLeft, except that the first value in the chain of
  * combined values is supplied in the call.)
  */
object Exercise04 extends App {
  println("Chapter 12 Exercise 04")

  println(factorial(5))
  println(factorial(0))
  def factorial(n: Int) =  (1 to n).foldLeft (1) {(x: Int, y: Int) => x * y}
}
