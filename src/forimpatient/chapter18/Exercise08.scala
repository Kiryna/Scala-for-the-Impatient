package forimpatient.chapter18

/**
  * Created by Iryna Kharaborkina on 8/29/16. 
  *
  * Solution to the Chapter 18 Exercise 08 'Scala for the Impatient' by Horstmann C.S.
  *
  * Write a function printValues with three parameters f, from, to that prints all values of f
  * with inputs from the given range. Here, f should be any object with an apply method that consumes
  * and yields an Int. For example,
  *       printValues((x: Int) => x * x, 3, 6) // Prints 9 16 25 36
  *       printValues(Array(1, 1, 2, 3, 5, 8, 13, 21, 34, 55), 3, 6) // Prints 3 5 8 13
  */
object Exercise08 extends App {
  println("Chapter 18 Exercise 08")

  printValues((x: Int) => x * x, 3, 6)
  printValues(Array(1, 1, 2, 3, 5, 8, 13, 21, 34, 55), 3, 6)

  def printValues(f: {def apply(i: Int): Int}, start: Int, end: Int): Unit = {
    val range = start to end
    println((for (i <- range) yield f(i)).mkString(" "))
  }
}
