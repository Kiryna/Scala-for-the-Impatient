package forimpatient.chapter08

/**
  * Created by Iryna Kharaborkina on 8/6/16. 
  *
  * Solution to the Chapter 08 Exercise 05 'Scala for the Impatient' by Horstmann C.S.
  *
  * Design a class Point whose x and y coordinate values can be provided in a constructor.
  * Provide a subclass LabeledPoint whose constructor takes a label value and x and y coordinates, such as
  *     new LabeledPoint("Black Thursday", 1929, 230.07)
  */
object Exercise05 extends App {
  println("Chapter 08 Exercise 05")

  val blackThursday = new LabeledPoint("Black Thursday", 1929, 230.07)
  println(blackThursday.label)
  println(blackThursday.x)
  println(blackThursday.y)

  class LabeledPoint(val label: String, x: Double, y: Double) extends Point(x: Double, y: Double)
  class Point(val x: Double, val y: Double)
}
