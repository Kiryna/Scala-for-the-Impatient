package forimpatient.chapter12

/**
  * Created by Iryna Kharaborkina on 8/9/16. 
  *
  * Solution to the Chapter 12 Exercise 06 'Scala for the Impatient' by Horstmann C.S.
  *
  * Modify the previous function to return the input at which the output is largest.
  * For example, largestAt(fun: (Int) => Int, inputs: Seq[Int]) should return 5.
  * Don’t use a loop or recursion.
  */
object Exercise06 extends App {
  println("Chapter 12 Exercise 06")

  val lrg: Int = largest(x => 10 * x - x * x, 1 to 10)
  println(lrg)

  def largest(fun: (Int) => Int, inputs: Seq[Int]) =
    inputs.map((x: Int) => (x, fun(x))).reduceLeft((x, y) => if (x._2 > y._2) x else y)._1
}
