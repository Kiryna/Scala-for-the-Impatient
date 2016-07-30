package forimpatient.chapter04

/**
  * Created by Iryna Kharaborkina on 7/30/16. 
  *
  * Solution to the Chapter 04 Exercise 09 'Scala for the Impatient' by Horstmann C.S.
  *
  * Write a function lteqgt(values: Array[Int], v: Int) that returns a triple containing
  * the counts of values less than v, equal to v, and greater than v.
  */
object Exercise09 extends App {
  println("Chapter 04 Exercise 09")

  println(lteqgt((1 to 10).toArray, 4))
  println(lteqgt(Array(5, 7, -1,  9, 2, -6), 2))

  def lteqgt(values: Array[Int], v: Int) = (values.count(_ < v), values.count(_ == v), values.count(_ > v))
}
