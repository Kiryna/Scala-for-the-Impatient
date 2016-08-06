package forimpatient.chapter08

/**
  * Created by Iryna Kharaborkina on 8/6/16. 
  *
  * Solution to the Chapter 08 Exercise 07 'Scala for the Impatient' by Horstmann C.S.
  *
  * Provide a class Square that extends java.awt.Rectangle and has three constructors:
  * one that constructs a square with a given corner point and width,
  * one that constructs a square with corner (0, 0) and a given width,
  * and one that constructs a square with corner (0, 0) and width 0.
  */
object Exercise07 extends App {
  println("Chapter 08 Exercise 07")

  val squares = Array(new Square(2, 2, 4), new Square(5), new Square())
  for (square <- squares) println(square)

  class Square(x: Int, y: Int, width: Int) extends java.awt.Rectangle(x, y, width, width) {
    def this(width: Int) = this(0, 0, width)
    def this() = this(0, 0, 0)
    override def toString: String = "Square[x=" + getX + ", y=" + getY + ", w=" + getWidth + "]"
  }
}
