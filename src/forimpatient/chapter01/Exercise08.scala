package forimpatient.chapter01

import scala.BigInt._
import scala.util.Random

/**
  * Created by Iryna Kharaborkina on 7/25/16.
  *
  * Solution to the Chapter 01 Exercise 08 'Scala for the Impatient' by Horstmann C.S.
  *
  * One way to create random file or directory names is to produce a random BigInt and convert it
  * to base 36, yielding a string such as "qsnvbevtomcj38o06kul". Poke around Scaladoc to find a way of
  * doing this in Scala.
  */
object Exercise08 extends App {
  println("Chapter 01 Exercise 08")

  val name = probablePrime(100, Random).toString(36)
  println(name)
}
