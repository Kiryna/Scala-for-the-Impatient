package forimpatient.chapter17

/**
  * Created by Iryna Kharaborkina on 8/24/16. 
  *
  * Solution to the Chapter 17 Exercise 02 'Scala for the Impatient' by Horstmann C.S.
  *
  * Define a mutable class Pair[T] with a method swap that swaps the components of the pair.
  */
object Exercise02 extends App {
  println("Chapter 17 Exercise 02")

  val a = new Pair[Int](1, 2)

  println(a)
  a.swap()
  println(a)

  class Pair[T](var first: T, var second: T) {
    def swap() = {val tmp = second; second = first; first = tmp}

    override def toString: String = "Pair[" + first + " -> " + second + "]"
  }
}
