package forimpatient.chapter08

import scala.collection.mutable.ArrayBuffer

/**
  * Created by Iryna Kharaborkina on 8/6/16. 
  *
  * Solution to the Chapter 08 Exercise 04 'Scala for the Impatient' by Horstmann C.S.
  *
  * Define an abstract class Item with methods price and description. A SimpleItem is an item
  * whose price and description are specified in the constructor. Take advantage of the fact
  * that a val can override a def. A Bundle is an item that contains other items.
  * Its price is the sum of the prices in the bundle. Also provide a mechanism for adding items to the bundle
  * and a suitable description method.
  */
object Exercise04 extends App {
  println("Chapter 08 Exercise 04")

  val items = new Bundle
  println(items.description + ": price = " + items.price)

  items += new SimpleItem("bucket", 12.5)
  items += new SimpleItem("mop", 5)
  items += new SimpleItem("broom", 8.8)

  println(items.description + ": price = " + items.price)

  class Bundle extends Item {
    val items = new ArrayBuffer[Item]
    def +=(item: Item): Unit = items += item
    override def description = items.map(x => x.description).mkString("<", " and ", ">")
    override def price = items.map(_.price).sum
  }

  class SimpleItem(val description: String, val price: Double) extends Item

  abstract class Item {
    def description: String
    def price: Double
  }
}
