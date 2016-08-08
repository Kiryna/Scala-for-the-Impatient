package forimpatient.chapter10

import java.io.{BufferedInputStream, FileInputStream, InputStream}

/**
  * Created by Iryna Kharaborkina on 8/8/16. 
  *
  * Solution to the Chapter 10 Exercise 08 'Scala for the Impatient' by Horstmann C.S.
  *
  * In the java.io library, you add buffering to an input stream with a BufferedInputStream decorator.
  * Reimplement buffering as a trait. For simplicity, override the read method.
  */
object Exercise08 extends App {
  println("Chapter 10 Exercise 08")

  val fis = new FileInputStream("LICENSE") with Buffering
  val ar = new Array[Byte](64)
  fis.read(ar)
  println(ar.map(_.toChar).mkString(""))
  fis.read(ar)
  println(ar.map(_.toChar).mkString(""))

  trait Buffering {
    this: InputStream =>
    val bis = new BufferedInputStream(this)
    override def read(a: Array[Byte]) = bis.read(a)
  }

}
