package forimpatient.chapter12

/**
  * Created by Iryna Kharaborkina on 8/9/16. 
  *
  * Solution to the Chapter 12 Exercise 05 'Scala for the Impatient' by Horstmann C.S.
  *
  * Write a function largest(fun: (Int) => Int, inputs: Seq[Int]) that yields the largest value of a function
  * within a given sequence of inputs. For example, largest(x => 10 * x - x * x, 1 to 10) should return 25.
  * Don’t use a loop or recursion.
  */
object Exercise05 extends App {
  println("Chapter 12 Exercise 05")

  val lrg: Int = largest(x => 10 * x - x * x, 1 to 10)
  println(lrg)

  def largest(fun: (Int) => Int, inputs: Seq[Int]) = inputs.map(fun).max
}
