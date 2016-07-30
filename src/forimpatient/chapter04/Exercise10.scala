package forimpatient.chapter04

/**
  * Created by Iryna Kharaborkina on 7/30/16. 
  *
  * Solution to the Chapter 04 Exercise 10 'Scala for the Impatient' by Horstmann C.S.
  *
  * What happens when you zip together two strings, such as "Hello".zip("World")?
  * Come up with a plausible use case.
  */
object Exercise10 extends App {
  println("Chapter 04 Exercise 10")

  println("Hello".zip("World"))

  private val cesarCipher: Map[Char, Char] = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".zip("XYZABCDEFGHIJKLMNOPQRSTUVW").toMap
  val ciphered = "Hello, World!".toUpperCase.map(ch => cesarCipher.getOrElse(ch, ch))
  println(ciphered)
}
