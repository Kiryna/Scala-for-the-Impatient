package forimpatient.chapter14

/**
  * Created by Iryna Kharaborkina on 8/10/16. 
  *
  * Solution to the Chapter 14 Exercise 02 'Scala for the Impatient' by Horstmann C.S.
  *
  * Using pattern matching, write a function swap that receives a pair of integers
  * and returns the pairwith the components swapped.
  */
object Exercise02 extends App {
  println("Chapter 14 Exercise 02")

  println(swap(4, 5))

  def swap(p: (Int, Int)) = p match { case (a, b) => (b, a) }
}
