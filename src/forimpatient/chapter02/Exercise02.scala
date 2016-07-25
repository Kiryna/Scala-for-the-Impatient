package forimpatient.chapter02

/**
  * Created by Iryna Kharaborkina on 7/25/16. 
  *
  * Solution to the Chapter 02 Exercise 02 'Scala for the Impatient' by Horstmann C.S.
  *
  * What is the value of an empty block expression {}? What is its type?
  */
object Exercise02 extends App {
  println("Chapter 02 Exercise 02")

  println({})                     // Value is ()
  println({}.isInstanceOf[Unit])  // Type is Unit
}
