package forimpatient.chapter03

/**
  * Created by Iryna Kharaborkina on 7/28/16. 
  *
  * Solution to the Chapter 03 Exercise 07 'Scala for the Impatient' by Horstmann C.S.
  *
  * Write a code snippet that produces all values from an array with duplicates removed. (Hint: Look at Scaladoc.)
  */
object Exercise07 extends App {
  println("Chapter 03 Exercise 07")
  val a = Array(2, 5, 4, 1, 2, 5 ,7, 6, 2, 1, 4, 3, 7)
  println(a.mkString(", "))
  println(a.distinct.mkString(", "))
}
