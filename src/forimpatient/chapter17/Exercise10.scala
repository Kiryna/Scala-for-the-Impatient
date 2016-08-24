package forimpatient.chapter17

/**
  * Created by Iryna Kharaborkina on 8/24/16. 
  *
  * Solution to the Chapter 17 Exercise 10 'Scala for the Impatient' by Horstmann C.S.
  *
  * Given a mutable Pair[S, T] class, use a type constraint to define a swap method
  * that can be called if the type parameters are the same.
  */
object Exercise10 extends App {
  println("Chapter 17 Exercise 10")

  val a = new Pair(1, 2)
  val b = new Pair(1, "2")

  a.swap
  println(a)
  // b.swap - Error!
  println(b)


  class Pair[S, T](var first: S, var second: T) {
    def swap(implicit ev0: S =:= T, ev1: T =:= S) = {val tmp = second; second = first; first = tmp}

    override def toString: String = "Pair[" + first + " -> " + second + "]"
  }

}
