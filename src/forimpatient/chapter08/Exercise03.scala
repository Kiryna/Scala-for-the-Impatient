package forimpatient.chapter08

/**
  * Created by Iryna Kharaborkina on 8/6/16. 
  *
  * Solution to the Chapter 08 Exercise 03 'Scala for the Impatient' by Horstmann C.S.
  *
  * Consult your favorite Java or C++ textbook that is sure to have an example of a toy inheritance hierarchy,
  * perhaps involving employees, pets, graphical shapes, or the like. Implement the example in Scala.
  */
object Exercise03 extends App {
  println("Chapter 08 Exercise 03")

  val b = new Bicycle(1, 10, 2)
  println(b.speed)
  b.applyBrake(2)
  println(b.speed)

  val mountainBike = new MountainBike(2, 1, 8, 3)
  println(mountainBike.speed)
  mountainBike.applyBrake(3)
  println(mountainBike.speed)

  class MountainBike(var seatHeight: Int, cadence: Int, speed: Int, gear: Int) extends Bicycle(cadence: Int, speed: Int, gear: Int)

  class Bicycle(var cadence: Int, var speed: Int, var gear: Int) {
    def applyBrake(decrement: Int): Unit = {
      speed -= decrement
    }
  }

}
