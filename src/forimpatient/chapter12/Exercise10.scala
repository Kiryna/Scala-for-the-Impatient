package forimpatient.chapter12

/**
  * Created by Iryna Kharaborkina on 8/9/16. 
  *
  * Solution to the Chapter 12 Exercise 10 'Scala for the Impatient' by Horstmann C.S.
  *
  * Implement an unless control abstraction that works just like if, but with an inverted condition.
  * Does the first parameter need to be a call-by-name parameter? Do you need currying?
  */
object Exercise10 extends App {
  println("Chapter 12 Exercise 10")

  unless (2 == 5) {
    println("The conditions is false")
  }

  def unless(conditions: => Boolean)(block: => Unit): Unit = {
    if (!conditions) block
  }
}
