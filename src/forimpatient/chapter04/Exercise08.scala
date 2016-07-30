package forimpatient.chapter04

/**
  * Created by Iryna Kharaborkina on 7/30/16. 
  *
  * Solution to the Chapter 04 Exercise 08 'Scala for the Impatient' by Horstmann C.S.
  *
  * Write a function minmax(values: Array[Int]) that returns a pair containing the smallest
  * and largest values in the array.
  */
object Exercise08 extends App {
  println("Chapter 04 Exercise 08")

  println(minmax((1 to 10).toArray))
  println(minmax(Array(5, 7, -1,  9, 2, -6)))

  def minmax(values: Array[Int]) = (values.min, values.max)
}
