package forimpatient.chapter06

/**
  * Created by Iryna Kharaborkina on 8/3/16. 
  *
  * Solution to the Chapter 06 Exercise 08 'Scala for the Impatient' by Horstmann C.S.
  *
  * Write an enumeration describing the eight corners of the RGB color cube. As IDs, use the color values
  * (for example, 0xff0000 for Red).
  */
object Exercise08 extends App {
  println("Chapter 06 Exercise 08")

  for (color <- ColorCube.values) println(color.toString + " = " + color.id)

  object ColorCube extends Enumeration {
    val Black = Value(0x000000)
    val Red = Value(0xff0000)
    val Green = Value(0x00ff00)
    val Blue = Value(0x0000ff)
    val Magenta = Value(0xff00ff)
    val Cyan = Value(0x00ffff)
    val Yellow = Value(0xffff00)
    val White = Value(0xffffff)
  }
}
