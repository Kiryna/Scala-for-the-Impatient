package forimpatient.chapter17

/**
  * Created by Iryna Kharaborkina on 8/24/16. 
  *
  * Solution to the Chapter 17 Exercise 01 'Scala for the Impatient' by Horstmann C.S.
  *
  * Define an immutable class Pair[T, S] with a method swap that returns a new pair with the components swapped.
  */
object Exercise01 extends App {
  println("Chapter 17 Exercise 01")

  val a = new Pair[Int, String](1, "Hello, World!")
  println(a)
  println(a.swap)

  class Pair[T, S](val first:T, val second: S) {
    def swap = new Pair[S, T](second, first)

    override def toString: String = "Pair[" + first + " -> " + second + "]"
  }

}
