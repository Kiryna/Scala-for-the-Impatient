package forimpatient.chapter13

import scala.io.Source

/**
  * Created by Iryna Kharaborkina on 8/10/16. 
  *
  * Solution to the Chapter 13 Exercise 10 'Scala for the Impatient' by Horstmann C.S.
  *
  * Harry Hacker reads a file into a string and wants to use a parallel collection to update the letter
  * frequencies concurrently on portions of the string. He uses the following code:
  *     val frequencies = new scala.collection.mutable.HashMap[Char, Int]
  *     for (c <- str.par) frequencies(c) = frequencies.getOrElse(c, 0) + 1
  * Why is this a terrible idea? How can he really parallelize the computation? (Hint: Use aggregate.)
  */
object Exercise10 extends App {
  println("Chapter 13 Exercise 10")

  val chars = Source.fromFile("src/forimpatient/chapter13/1.txt").mkString

  val frequencies = chars.par.aggregate(new scala.collection.mutable.HashMap[Char, Int])(
    (f, c) => {f(c) = f.getOrElse(c, 0) + 1; f},
    (f1, f2) => f1 ++ f2.map(p => p._1 -> (p._2 + f1.getOrElse(p._1, 0)))
  )
  println(frequencies)

}
