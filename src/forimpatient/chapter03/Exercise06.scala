package forimpatient.chapter03

/**
  * Created by Iryna Kharaborkina on 7/26/16. 
  *
  * Solution to the Chapter 03 Exercise 06 'Scala for the Impatient' by Horstmann C.S.
  *
  * How do you rearrange the elements of an Array[Int] so that they appear in reverse sorted order?
  * How do you do the same with an ArrayBuffer[Int]?
  */
object Exercise06 extends App {
  println("Chapter 03 Exercise 06")
  val a = Array(1, 3, 5, 4, 2)
  val b = a.toBuffer

  println(a.mkString(", "))
  println(b.mkString(", "))
  println(a.sortWith(_ > _).mkString(", "))
  println(b.sortWith(_ > _).mkString(", "))

}
