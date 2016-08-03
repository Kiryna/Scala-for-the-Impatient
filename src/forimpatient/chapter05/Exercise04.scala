package forimpatient.chapter05

/**
  * Created by Iryna Kharaborkina on 8/3/16. 
  *
  * Solution to the Chapter 05 Exercise 04 'Scala for the Impatient' by Horstmann C.S.
  *
  * Reimplement the Time class from the preceding exercise so that the internal representation is the
  * number of minutes since midnight (between 0 and 24 × 60 – 1). Do not change the public interface.
  * That is, client code should be unaffected by your change.
  */
object Exercise04 extends App {
  println("Chapter 05 Exercise 04")
  val a = new Time(10, 15)
  val b = new Time(12, 20)
  val c = new Time(12, 50)

  println(a.hours)
  println(a.minutes)

  println(a before b)
  println(b before c)
  println(c before a)

  class Time(h: Int, m: Int) {
    private val minutesInHour = 60
    private val fromMidnight = h * minutesInHour + m

    def before(other: Time) = fromMidnight < other.fromMidnight

    def hours = fromMidnight / minutesInHour

    def minutes = fromMidnight % minutesInHour
  }


}
