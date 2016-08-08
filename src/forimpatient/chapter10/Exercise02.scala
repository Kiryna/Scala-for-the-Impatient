package forimpatient.chapter10

import java.awt.Point

/**
  * Created by Iryna Kharaborkina on 8/8/16. 
  *
  * Solution to the Chapter 10 Exercise 02 'Scala for the Impatient' by Horstmann C.S.
  *
  * Define a class OrderedPoint by mixing scala.math.Ordered[Point] into java.awt.Point.
  * Use lexicographic ordering, i.e. (x, y) < (x’, y’) if x < x’ or x = x’ and y < y’
  */
object Exercise02 extends App {
  println("Chapter 10 Exercise 02")

  val points = Seq(new OrderedPoint(8, 1), new OrderedPoint(2, 9), new OrderedPoint(5, 1), new OrderedPoint(2, 4))
  println(points)
  println(points.sortBy(a => (a.getX, a.getY)))
  println(points(1) + " > " + points(3) + ": " + (points(1) > points(3)))
  println(points(0) + " < " + points(2) + ": " + (points(0) < points(2)))

  class OrderedPoint(x: Int, y: Int) extends Point(x: Int, y: Int) with Ordered[Point] {
    override def compare(that: Point): Int = {
      if (x < that.x && y < that.y) -1
      else if (x == that.x) {if (y < that.y) -1 else if (y == that.y) 0 else 1 }
      else 1
    }

    override def toString: String = "Point[" + x + "x" + y + "]"
  }
}
