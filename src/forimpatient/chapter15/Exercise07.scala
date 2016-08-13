package forimpatient.chapter15

import scala.annotation.tailrec

/**
  * Created by Iryna Kharaborkina on 8/13/16. 
  *
  * Solution to the Chapter 15 Exercise 07 'Scala for the Impatient' by Horstmann C.S.
  *
  * Give an example to show that the tail recursion optimization is not valid when a method can be overridden.
  */
object Exercise07 extends App {
  println("Chapter 15 Exercise 07")

  println(new SumUtil().sum(1 to 3, 0))
  println(sum(1 to 3, 0))

  @tailrec def sum(s: Seq[Int], el: Int): Int = {
    if (s.isEmpty) el else sum(s.tail, s.head + el)
  }

  class SumUtil {
    @tailrec final def sum(s: Seq[Int], el: Int): Int = {
      if (s.isEmpty) el else sum(s.tail, s.head + el)
    }
  }

}
