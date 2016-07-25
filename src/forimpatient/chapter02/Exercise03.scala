package forimpatient.chapter02

/**
  * Created by Iryna Kharaborkina on 7/25/16. 
  *
  * Solution to the Chapter 02 Exercise 03 'Scala for the Impatient' by Horstmann C.S.
  *
  * Come up with one situation where the assignment x = y = 1 is valid in Scala. (Hint: Pick a suitable type for x.)
  */
object Exercise03 extends App {
  println("Chapter 02 Exercise 03")
  var x = ()
  var y = 0

  x = y = 1

  println(x)
  println(y)
}