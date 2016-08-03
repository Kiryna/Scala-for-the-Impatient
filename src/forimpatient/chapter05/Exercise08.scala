package forimpatient.chapter05

import javax.print.attribute.standard.PrinterMoreInfoManufacturer

/**
  * Created by Iryna Kharaborkina on 8/3/16. 
  *
  * Solution to the Chapter 05 Exercise 08 'Scala for the Impatient' by Horstmann C.S.
  *
  * Make a class Car with read-only properties for manufacturer, model name, and model year,
  * and a read-write property for the license plate. Supply four constructors. All require the manufacturer
  * and model name. Optionally, model year and license plate can also be specified in the constructor.
  * If not, the model year is set to -1 and the license plate to the empty string.
  * Which constructor are you choosing as the primary constructor? Why?
  */
object Exercise08 extends App {
  println("Chapter 05 Exercise 08")
  val a = new Car("tesla", "fdf445", 2015, "dfdfdf")

  println(a.manufacturer)
  println(a.modelName)
  println(a.modelYear)
  println(a.license)

  a.license = "retrtr"
  println(a.license)

  val b = new Car("ford", "fdsfds")

  println(b.manufacturer)
  println(b.modelName)
  println(b.modelYear)
  println(b.license)

  b.license = "tytyty"
  println(b.license)

  class Car(val manufacturer: String, val modelName: String, val modelYear: Int, var license: String) {
    def this(manufacturer: String, modelName: String, modelYear: Int) {
      this(manufacturer, modelName, modelYear, "")
    }

    def this(manufacturer: String, modelName: String, license: String) {
      this(manufacturer, modelName, -1, license)
    }

    def this(manufacturer: String, modelName: String) {
      this(manufacturer, modelName, -1)
    }
  }
}
