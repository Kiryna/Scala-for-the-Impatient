package forimpatient.chapter01

/**
  * Created by Iryna Kharaborkina on 7/25/16. 
  *
  * Solution to the Chapter 01 Exercise 10 'Scala for the Impatient' by Horstmann C.S.
  *
  * What do the take, drop, takeRight, and dropRight string functions do? What advantage or
  * disadvantage do they have over using substring?
  */
object Exercise10 extends App {
  println("Chapter 01 Exercise 10")

  val str = "Exercise09"

  println(str.take(3)) // returns string, containing first n symbols; here n == 3
  println(str.drop(3)) // returns string, containing all but first n symbols; here n == 3
  println(str.dropRight(3)) // returns string, containing all but last n symbols; here n == 3
  println(str.takeRight(3)) // returns string, containing last n symbols; here n == 3
}