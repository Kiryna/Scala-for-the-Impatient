package forimpatient.chapter05

/**
  * Created by Iryna Kharaborkina on 7/30/16. 
  *
  * Solution to the Chapter 05 Exercise 01 'Scala for the Impatient' by Horstmann C.S.
  *
  * Improve the Counter class in Section 5.1, “Simple Classes and Parameterless Methods”,
  * so that it doesn’t turn negative at Int.MaxValue.
  */
object Exercise01 extends App {
  println("Chapter 05 Exercise 01")

  val c = new Counter(Int.MaxValue)

  println(c.current())
  c.increment()
  println(c.current())

  class Counter(private var value: Int = 0) {
    def increment() { if (value < Int.MaxValue) value += 1 }
    def current() = value
  }
}
