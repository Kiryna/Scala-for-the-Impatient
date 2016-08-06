package forimpatient.chapter08

/**
  * Created by Iryna Kharaborkina on 8/6/16. 
  *
  * Solution to the Chapter 08 Exercise 09 'Scala for the Impatient' by Horstmann C.S.
  *
  * In the Creature class of Section 8.10, “Construction Order and Early Definitions,” on page 92,
  * replace val range with a def. What happens when you also use a def in the Ant subclass?
  * What happens when you use a val in the subclass? Why?
  */
object Exercise09 extends App {
  val ant = new Ant
  println(ant.env.length)

  val antWeird = new AntWeird
  println(antWeird.env.length)

  class Ant extends {override val range = 2}  with Creature {
  }

  class AntWeird extends Creature {
    override val range = 2
  }

  class Creature {
    def range: Int = 10
    val env: Array[Int] = new Array[Int](range)
  }
}
