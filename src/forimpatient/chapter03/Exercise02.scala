package forimpatient.chapter03

/**
  * Created by Iryna Kharaborkina on 7/26/16. 
  *
  * Solution to the Chapter 03 Exercise 02 'Scala for the Impatient' by Horstmann C.S.
  *
  * Write a loop that swaps adjacent elements of an array of integers. For example, Array(1, 2, 3, 4, 5)
  * becomes Array(2, 1, 4, 3, 5).
  */
object Exercise02 extends App {
  println("Chapter 03 Exercise 02")
  val a = Array(1, 2, 3, 4, 5)
  for (i <- 1 until(a.length, 2)) {
    val tmp = a(i - 1); a(i - 1) = a(i); a(i) = tmp
  }
  println(a.mkString(", "))
}