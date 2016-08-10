package forimpatient.chapter13

/**
  * Created by Iryna Kharaborkina on 8/9/16. 
  *
  * Solution to the Chapter 13 Exercise 07 'Scala for the Impatient' by Horstmann C.S.
  *
  * The expression
  *     (prices zip quantities) map { p => p._1 * p._2 }
  * is a bit inelegant.
  * We can’t do (prices zip quantities) map { _ * _ } because _ * _ is a function with two arguments,
  * and we need a function with one argument that is a tuple. The tupled method of the Function2 object
  * changes a function with two arguments to one that takes a tuple.
  * Apply tupled to the multiplication function so you can map it over the list of pairs.
  */
object Exercise07 extends App {
  println("Chapter 13 Exercise 07")

  val prices = List(5.0, 20.0, 9.95)
  val quantities = List(10, 2, 1)
  val mult = ((x: Double, y : Int) => x * y).tupled

  val fullPrices = (prices zip quantities) map { mult(_)}
  println(fullPrices)
}
