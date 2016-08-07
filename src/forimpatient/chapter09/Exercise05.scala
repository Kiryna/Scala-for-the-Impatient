package forimpatient.chapter09

import java.io.PrintWriter

/**
  * Created by Iryna Kharaborkina on 8/7/16. 
  *
  * Solution to the Chapter 09 Exercise 05 'Scala for the Impatient' by Horstmann C.S.
  *
  * Write a Scala program that writes the powers of 2 and their reciprocals to a file,
  * with the exponent ranging from 0 to 20. Line up the columns:
  *   1  1
  *   2  0.5
  *   4  0.25
  */
object Exercise05 extends App {
  println("Chapter 09 Exercise 05")

  import math._
  val out = new PrintWriter("src/forimpatient/chapter09/Exercise05.txt")
  out.print("powers".formatted("%10s\t"))
  out.println("reciprocals")
  for (i <- 0 to 10) {val p = pow(2, i); out.print(p.toInt.formatted("%10d\t")); out.println((1 / p))}
  out.close()

}
