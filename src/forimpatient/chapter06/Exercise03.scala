package forimpatient.chapter06

import java.awt.Point

/**
  * Created by Iryna Kharaborkina on 8/3/16. 
  *
  * Solution to the Chapter 06 Exercise 03 'Scala for the Impatient' by Horstmann C.S.
  *
  * Define an Origin object that extends java.awt.Point. Why is this not actually a good idea?
  * (Have a close look at the methods of the Point class.)
  */
object Exercise03 extends App {
  println("Chapter 06 Exercise 03")

  val a = Origin
  val b = Origin

  println(a)
  println(b)

  b.move(2, 2) // Actually both moved

  println(a)
  println(b)

  object Origin extends Point {
    override def toString = "[" + x + ", " + y + "]"
  }
}
