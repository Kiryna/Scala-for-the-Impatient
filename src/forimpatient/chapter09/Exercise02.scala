package forimpatient.chapter09

import java.io.{PrintWriter}

import scala.io.Source

/**
  * Created by Iryna Kharaborkina on 8/6/16. 
  *
  * Solution to the Chapter 09 Exercise 02 'Scala for the Impatient' by Horstmann C.S.
  *
  * Write a Scala program that reads a file with tabs, replaces each tab with spaces
  * so that tab stops are at n-column boundaries, and writes the result to the same file.
  */
object Exercise02 extends App {
  println("Chapter 09 Exercise 02")

  val path = "src/forimpatient/chapter09/Exercise02.txt"
  val lines = Source.fromFile(path).getLines().toArray
  val out = new PrintWriter(path)

  for (line <-  lines) out.println(line.split("\t").foldLeft("")((x, y) => x + y + " " * (10 - y.length)))
  out.close()
}