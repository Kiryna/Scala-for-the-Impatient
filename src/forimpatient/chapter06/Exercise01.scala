package forimpatient.chapter06

/**
  * Created by Iryna Kharaborkina on 8/3/16. 
  *
  * Solution to the Chapter 06 Exercise 01 'Scala for the Impatient' by Horstmann C.S.
  *
  * Write an object Conversions with methods inchesToCentimeters, gallonsToLiters, and milesToKilometers.
  */
object Exercise01 extends App {
  println("Chapter 06 Exercise 01")

  println(Conversions.inchesToCentimeters(10))
  println(Conversions.gallonsToLiters(10))
  println(Conversions.milesToKilometers(10))

  object Conversions {
    def inchesToCentimeters(inches: Double) = inches * 2.54
    def gallonsToLiters(gallons: Double) = gallons * 3.78541178
    def milesToKilometers(miles: Double) = miles * 1.609344
  }

}
