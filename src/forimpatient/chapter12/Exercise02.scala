package forimpatient.chapter12

/**
  * Created by Iryna Kharaborkina on 8/9/16. 
  *
  * Solution to the Chapter 12 Exercise 02 'Scala for the Impatient' by Horstmann C.S.
  *
  * How do you get the largest element of an array with reduceLeft?
  */
object Exercise02 extends App {
  println("Chapter 12 Exercise 02")

  println(Array(5, 1, 9, 5, 4, 3).reduceLeft(_ max _))
}
