package forimpatient.chapter12

/**
  * Created by Iryna Kharaborkina on 8/9/16. 
  *
  * Solution to the Chapter 12 Exercise 09 'Scala for the Impatient' by Horstmann C.S.
  *
  * Implement corresponds without currying. Then try the call from the preceding exercise.
  * What problem do you encounter?
  */
object Exercise09 extends App {
  println("Chapter 12 Exercise 09")

  val a = Array("Hello", "World", "Ira")
  val b = Array(5, 5, 3)
  println(corresponds[String, Int](a, b, _.length == _))

  b(2) = 4
  println(corresponds[String, Int](a, b, _.length == _))

  def corresponds[A, B](a: Seq[A], b: Seq[B], fun: (A, B) => Boolean) = {
    a.corresponds(b)(fun)
  }
}
