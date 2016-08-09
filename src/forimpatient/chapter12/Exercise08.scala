package forimpatient.chapter12

/**
  * Created by Iryna Kharaborkina on 8/9/16. 
  *
  * Solution to the Chapter 12 Exercise 08 'Scala for the Impatient' by Horstmann C.S.
  *
  * Make a call to corresponds that checks whether the elements in an array of strings
  * have the lengths given in an array of integers.
  */
object Exercise08 extends App {
  println("Chapter 12 Exercise 08")

  val a = Array("Hello", "World", "Ira")
  val b = Array(5, 5, 3)

  println(a.corresponds(b)(_.length == _))

  b(2) = 4
  println(a.corresponds(b)(_.length == _))
}
