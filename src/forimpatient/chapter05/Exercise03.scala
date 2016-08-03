package forimpatient.chapter05

/**
  * Created by Iryna Kharaborkina on 8/1/16. 
  *
  * Solution to the Chapter 05 Exercise 03 'Scala for the Impatient' by Horstmann C.S.
  *
  * Write a class Time with read-only properties hours and minutes and a method before(other: Time):Boolean
  * that checks whether this time comes before the other. A Time object should be constructed as
  * new Time(hrs, min), where hrs is in military time format (between 0 and 23).
  */
object Exercise03 extends App {
  println("Chapter 05 Exercise 03")
  val a = new Time(10, 15)
  val b = new Time(12, 20)
  val c = new Time(12, 50)

  println(a.hours)
  println(a.minutes)

  println(a before b)
  println(b before c)
  println(c before a)

  class Time(val hours: Int, val minutes: Int) {
    def before(other: Time) = hours < other.hours || (hours == other.hours && minutes < other.minutes)
  }

}
