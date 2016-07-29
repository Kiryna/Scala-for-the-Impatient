package forimpatient.chapter04

/**
  * Created by Iryna Kharaborkina on 7/29/16. 
  *
  * Solution to the Chapter 04 Exercise 01 'Scala for the Impatient' by Horstmann C.S.
  *
  * Set up a map of prices for a number of gizmos that you covet. Then produce a second map with
  * the same keys and the prices at a 10 percent discount.
  */
object Exercise01 extends App {
  println("Chapter 04 Exercise 01")

  val m = Map("P1" -> 10, "P2" -> 2, "P3" -> 8, "P4" -> 6)
  val discount = m.map(pair => (pair._1, pair._2 * 0.9))
  println(discount)
}
