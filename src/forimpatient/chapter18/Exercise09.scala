package forimpatient.chapter18

/**
  * Created by Iryna Kharaborkina on 8/29/16. 
  *
  * Solution to the Chapter 18 Exercise 09 'Scala for the Impatient' by Horstmann C.S.
  *
  * Consider this class that models a physical dimension:
  *       abstract class Dim[T](val value: Double, val name: String) {
  *         protected def create(v: Double): T
  *         def +(other: Dim[T]) = create(value + other.value)
  *         override def toString() = value + " " + name
  *       }
  * Here is a concrete subclass:
  *       class Seconds(v: Double) extends Dim[Seconds](v, "s") {
  *         override def create(v: Double) = new Seconds(v)
  *       }
  * But now a knucklehead could define
  *       class Meters(v: Double) extends Dim[Seconds](v, "m") {
  *         override def create(v: Double) = new Seconds(v)
  *       }
  * allowing meters and seconds to be added. Use a self type to prevent that.
  */
object Exercise09 extends App {
  println("Chapter 18 Exercise 09")

  abstract class Dim[T](val value: Double, val name: String) {
    this: T=>
    protected def create(v: Double): T
    def +(other: Dim[T]) = create(value + other.value)
    override def toString() = value + " " + name
  }

  class Seconds(v: Double) extends Dim[Seconds](v, "s") {
    override def create(v: Double) = new Seconds(v)
  }

  class Meters(v: Double) extends Dim[Meters](v, "m") { // Must use Meters
    override def create(v: Double) = new Meters(v)
  }
}
