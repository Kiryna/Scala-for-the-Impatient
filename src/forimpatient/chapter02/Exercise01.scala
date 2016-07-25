package forimpatient.chapter02

/**
  * Created by Iryna Kharaborkina on 7/25/16. 
  *
  * Solution to the forimpatient.chapter02 Exercise 08 'Scala for the Impatient' by Horstmann C.S.
  */
object Exercise01 extends App {
  override def main(args: Array[String]): Unit = {
    println("Chapter 02 Exercise 01")

    println(signum(-6))
    println(signum(0))
    println(signum(24))
  }

  def signum(x: Double) = if (x < 0) -1 else if (x == 0) 0 else 1
}