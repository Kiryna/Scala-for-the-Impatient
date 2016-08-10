package forimpatient.chapter13

/**
  * Created by Iryna Kharaborkina on 8/9/16. 
  *
  * Solution to the Chapter 13 Exercise 08 'Scala for the Impatient' by Horstmann C.S.
  *
  * Write a function that turns an array of Double values into a two-dimensional array.
  * Pass the number of columns as a parameter. For example, with Array(1, 2, 3, 4, 5, 6) and three columns,
  * return Array(Array(1, 2, 3), Array(4, 5, 6)). Use the grouped method
  */
object Exercise08 extends App {
  println("Chapter 13 Exercise 08")

  val arrayTwo =  convertArray(Array(1, 2, 3, 4, 5, 6), 3)
  println(arrayTwo.map(_.mkString("Array(", ", ", ")")).mkString(", "))

  def convertArray(a: Array[Double], n: Int) = a.grouped(n).toArray
}
