package forimpatient.chapter17

/**
  * Created by Iryna Kharaborkina on 8/24/16. 
  *
  * Solution to the Chapter 17 Exercise 03 'Scala for the Impatient' by Horstmann C.S.
  *
  * Given a class Pair[T, S], write a generic method swap that takes a pair as its argument
  * and returns a new pair with the components swapped.
  */
object Exercise03 extends App {
  println("Chapter 17 Exercise 03")

  val a = new Pair[Int, String](1, "Hello, World!")

  println(a)
  println(swap(a))

  def swap[T, S](pair: Pair[T, S]) = new Pair[S, T](pair.second, pair.first)

  class Pair[T, S](val first: T, val second: S) {
    override def toString: String = "Pair[" + first + " -> " + second + "]"
  }
}
