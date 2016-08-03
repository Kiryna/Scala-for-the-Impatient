package forimpatient.chapter06

/**
  * Created by Iryna Kharaborkina on 8/3/16. 
  *
  * Solution to the Chapter 06 Exercise 02 'Scala for the Impatient' by Horstmann C.S.
  *
  * The preceding problem wasn’t very object-oriented. Provide a general superclass UnitConversion
  * and define objects InchesToCentimeters, GallonsToLiters, and MilesToKilometers that extend it.
  */
object Exercise02 extends App {
  println("Chapter 06 Exercise 02")

  println(InchesToCentimeters.convert(10))
  println(GallonsToLiters.convert(10))
  println(MilesToKilometers.convert(10))


  object InchesToCentimeters extends UnitConversions(2.54)
  object GallonsToLiters extends UnitConversions(3.78541178)
  object MilesToKilometers extends UnitConversions(1.609344)

  class UnitConversions(private val conv: Double) {
    def convert(amount: Double) = amount * conv
  }
}
