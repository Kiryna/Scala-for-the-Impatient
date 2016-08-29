package forimpatient.chapter18

import scala.io.Source

/**
  * Created by Iryna Kharaborkina on 8/29/16. 
  *
  * Solution to the Chapter 18 Exercise 07 'Scala for the Impatient' by Horstmann C.S.
  *
  * Implement a method that receives an object of any class that has a method
  *       def close(): Unit
  * together with a function that processes that object. Call the function and invoke the close method upon completion,
  * or when any exception occurs.
  */
object Exercise07 extends App {
  println("Chapter 18 Exercise 07")
  val source = Source.fromFile("LICENSE")
  def printSource(s: Source) = println(s.mkString)

  runWithClose(source, printSource)

  def runWithClose[T](target: T { def close(): Unit }, fun: Function[T, Unit]) = {
    try {
      fun(target)
    } finally {
      println("!!!!!! And closing now !!!!!!")
      target.close()
    }
  }
}

