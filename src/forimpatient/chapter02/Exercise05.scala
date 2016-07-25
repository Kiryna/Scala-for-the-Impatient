package forimpatient.chapter02

/**
  * Created by Iryna Kharaborkina on 7/25/16. 
  *
  * Solution to the Chapter 02 Exercise 05 'Scala for the Impatient' by Horstmann C.S.
  *
  * Write a procedure countdown(n: Int) that prints the numbers from n to 0.
  */
object Exercise05 extends App {
  println("Chapter 02 Exercise 05")
  countdown(10)
  println()
  countdown(5)
  println()
  countdown(-2)
  println()
  countdown(0)

  def countdown(n: Int): Unit = {
    for (i <- n to (0, if (n < 0) 1 else -1)) println(i)
  }
}
