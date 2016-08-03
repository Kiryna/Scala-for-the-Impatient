package forimpatient.chapter06

/**
  * Created by Iryna Kharaborkina on 8/3/16. 
  *
  * Solution to the Chapter 06 Exercise 04 'Scala for the Impatient' by Horstmann C.S.
  *
  * Define a Point class with a companion object so that you can construct Point instances as Point(3, 4),
  * without using new.
  */
object Exercise04 extends App {
  println("Chapter 06 Exercise 04")

  val p = Point(3, 4)

  println(p.x)
  println(p.y)

  class Point(val x: Double, val y: Double)

  object Point {
    def apply(x: Double, y: Double): Point = new Point(x, y)
  }

}
