package forimpatient.chapter08

/**
  * Created by Iryna Kharaborkina on 8/6/16. 
  *
  * Solution to the Chapter 08 Exercise 06 'Scala for the Impatient' by Horstmann C.S.
  *
  * Define an abstract class Shape with an abstract method centerPoint and subclasses Rectangle and Circle.
  * Provide appropriate constructors for the subclasses and override the centerPoint method in each subclass.
  */
object Exercise06 extends App {
  println("Chapter 08 Exercise 06")

  val shapes = new Array[Shape](2)
  shapes(0) = new Rectangle(1, 1, 2, 2)
  shapes(1) = new Circle(3, 3, 1)

  for (shape <- shapes) println(shape.centerPoint)

  class Circle(centerX: Double, centerY: Double, radius: Double) extends Shape {
    override def centerPoint: (Double, Double) = (centerX, centerY)
  }

  class Rectangle(left: Double, top: Double, width: Double, height: Double) extends Shape {
    override def centerPoint: (Double, Double) = (left + width / 2, top + height / 2)
  }

  abstract class Shape {
    def centerPoint: (Double, Double)
  }
}
