package forimpatient.chapter10

import java.io.{FileInputStream, InputStream}

/**
  * Created by Iryna Kharaborkina on 8/8/16. 
  *
  * Solution to the Chapter 10 Exercise 10 'Scala for the Impatient' by Horstmann C.S.
  *
  * Implement a class IterableInputStream that extends java.io.InputStream with the trait Iterable[Byte].
  */
object Exercise10 extends App {
  println("Chapter 10 Exercise 10")

  val iis = new IterableInputStream(new FileInputStream("LICENSE"))
  while (iis.iterator.hasNext) print(iis.iterator.next().toChar)

  class IterableInputStream(stream: InputStream) extends InputStream with Iterable[Byte] {
    override def read: Int = stream.read()
    override def iterator: Iterator[Byte] = it

    val it = new Iterator[Byte] {
      override def hasNext: Boolean = stream.available() > 0
      override def next(): Byte = stream.read().toByte
    }
  }

}
