package forimpatient.chapter04

import java.util.Calendar

import scala.collection.mutable

/**
  * Created by Iryna Kharaborkina on 7/30/16. 
  *
  * Solution to the Chapter 04 Exercise 06 'Scala for the Impatient' by Horstmann C.S.
  *
  * Define a linked hash map that maps "Monday" to java.util.Calendar.MONDAY, and similarly for the other weekdays.
  * Demonstrate that the elements are visited in insertion order.
  */
object Exercise06 extends App {
  println("Chapter 04 Exercise 06")

  val m = mutable.LinkedHashMap[String, Int](

    "Monday" -> Calendar.MONDAY,
    "Tuesday" -> Calendar.TUESDAY,
    "Wednesday" -> Calendar.WEDNESDAY,
    "Thursday" -> Calendar.THURSDAY,
    "Friday" -> Calendar.FRIDAY,
    "Saturday" -> Calendar.SATURDAY,
    "Sunday" -> Calendar.SUNDAY
  )

  println(m)
}
