package forimpatient.chapter14

/**
  * Created by Iryna Kharaborkina on 8/10/16. 
  *
  * Solution to the Chapter 14 Exercise 03 'Scala for the Impatient' by Horstmann C.S.
  *
  * Using pattern matching, write a function swap that swaps the first two elements of an array
  * provided its length is at least two.
  */
object Exercise03 extends App {
  println("Chapter 14 Exercise 03")

  println(swap(Array(5, 6, 9, 10)).mkString(", "))
  println(swap(Array(5, 6, 9)).mkString(", "))
  println(swap(Array(5, 6)).mkString(", "))
  println(swap(Array(5)).mkString(", "))

  def swap(arr: Array[Int]) = arr match {
    case Array(a, b) => Array(b, a)
    case Array(a, b, tail @ _*) => Array(b, a) ++ tail
    case _ => arr
  }
}
