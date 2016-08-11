package forimpatient.chapter14

/**
  * Created by Iryna Kharaborkina on 8/11/16. 
  *
  * Solution to the Chapter 14 Exercise 04 'Scala for the Impatient' by Horstmann C.S.
  *
  * Add a case class Multiple that is a subclass of the Item class. For example,
  *     Multiple(10, Article("Blackwell Toaster", 29.95))
  * describes ten toasters. Of course, you should be able to handle any items, such as bundles or multiples,
  * in the second argument. Extend the price function to handle this new case.
  */
object Exercise04 extends App {
  println("Chapter 14 Exercise 04")

  val toaster = Multiple(10, Article("Blackwell Toaster", 29.95))
  println(toaster)
  println(toaster.count)
  println(price(toaster))

  def price(item: Item): Double = item match {
    case Multiple(c, items @ _*) => c * items.map(price).sum
    case Article(d, p) => p
    case Bundle(d, disc, items @ _*) => items.map(price).sum * disc
  }

  case class Multiple(count: Int, items: Item*) extends Item

  case class Article(description: String, price: Double) extends Item

  case class Bundle(description: String, discount: Double, items: Item*) extends Item

  abstract class Item
}
