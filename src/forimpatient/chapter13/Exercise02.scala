package forimpatient.chapter13

/**
  * Created by Iryna Kharaborkina on 7/25/16. 
  *
  * Solution to the Chapter 13 Exercise 02 'Scala for the Impatient' by Horstmann C.S.
  *
  * Write a function that, given a string, produces a map of the indexes of all characters. For
  * example, indexes("Mississippi") should return a map associating 'M' with the set {0}, 'i' with the set
  * {1, 4, 7, 10}, and so on. Use an immutable map of characters to lists.
  */
object Exercise02 extends App {
  println("Chapter 13 Exercise 02")
  println(indexes("Missisipi"))

  def indexes(str: String) = {
    (Map[Char, List[Int]]() /: str.zipWithIndex) {
      (m, c) => m + (c._1 -> (m.getOrElse(c._1, Nil) :+ c._2))
    }
  }

}
