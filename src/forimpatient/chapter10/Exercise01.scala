package forimpatient.chapter10

import java.awt.geom.Ellipse2D.{Double => Ellipse2D}
/**
  * Created by Iryna Kharaborkina on 8/8/16. 
  *
  * Solution to the Chapter 10 Exercise 01 'Scala for the Impatient' by Horstmann C.S.
  *
  * The java.awt.Rectangle class has useful methods translate and grow that are unfortunately absent from classes
  * such as java.awt.geom.Ellipse2D. In Scala, you can fix this problem. Define a trait RectangleLike
  * with concrete methods translate and grow. Provide any abstract methods that you need for the implementation,
  * so that you can mix in the trait like this:
  *     val egg = new java.awt.geom.Ellipse2D.Double(5, 10, 20, 30) with RectangleLike
  *     egg.translate(10, -10)
  *     egg.grow(10, 20)
  */
object Exercise01 extends App {
  println("Chapter 10 Exercise 01")

  val egg = new Ellipse2D(5, 10, 20, 30) with RectangleLike
  egg.translate(10, -10)
  println(egg)
  egg.grow(10, 20)
  println(egg)

  trait RectangleLike {
    def getX: Double
    def getY: Double
    def getWidth: Double
    def getHeight: Double
    def setFrame(x: Double, y: Double, width: Double, height: Double): Unit
    def translate(dX: Double, dY: Double): Unit = setFrame(getX + dX, getY + dY, getWidth, getHeight)
    def grow(growX: Double, growY: Double): Unit = setFrame(getX - growX / 2, getY - growY / 2, getWidth + growX, getHeight + growY)
    override def toString = "top/left[" + getX + "x" + getY + "]  width/height[" + getWidth + "x" + getHeight + "]"
  }
}
