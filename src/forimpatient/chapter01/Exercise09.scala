package forimpatient.chapter01

/**
  * Created by Iryna Kharaborkina on 7/25/16. 
  *
  * Solution to the Chapter 01 Exercise 09 'Scala for the Impatient' by Horstmann C.S.
  *
  * How do you get the first character of a string in Scala? The last character?
  */
object Exercise09 extends App {
  override def main(args: Array[String]): Unit = {
    println("Chapter 01 Exercise 09")

    val str = "Exercise09"
    println(str.head)
    println(str.last)
  }
}
