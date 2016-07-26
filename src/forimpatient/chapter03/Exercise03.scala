package forimpatient.chapter03

/**
  * Created by Iryna Kharaborkina on 7/26/16. 
  *
  * Solution to the Chapter 03 Exercise 03 'Scala for the Impatient' by Horstmann C.S.
  *
  * Repeat the preceding assignment, but produce a new array with the swapped values. Use for/yield
  */
object Exercise03 extends App {
  println("Chapter 03 Exercise 03")
  val a = Array(1, 2, 3, 4, 5)
  val b = for (i <- a.indices) yield if (i % 2 == 0 && i == a.length - 1) a(i) else if (i % 2 == 0) a(i + 1) else a(i - 1)
  println(b.mkString(", "))
}
