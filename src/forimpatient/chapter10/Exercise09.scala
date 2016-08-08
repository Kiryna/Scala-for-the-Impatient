package forimpatient.chapter10

import java.io.{BufferedInputStream, FileInputStream, InputStream}

/**
  * Created by Iryna Kharaborkina on 8/8/16. 
  *
  * Solution to the Chapter 10 Exercise 09 'Scala for the Impatient' by Horstmann C.S.
  *
  * Using the logger traits from this chapter, add logging to the solution of the preceding problem
  * that demonstrates buffering.
  */
object Exercise09 extends App {
  println("Chapter 10 Exercise 09")

  val fis = new FileInputStream("myfile.txt") with Buffering {
    override def log(msg: String): Unit = println(msg)
  }
  val ar = new Array[Byte](64)
  for (i<- 1 to 16) {
    fis.read(ar)
    println(ar.map(_.toChar).mkString(""))
  }

  trait Buffering extends Logger {
    this: InputStream =>
    val bis = new BufferedInputStream(this)
    override def read(a: Array[Byte]) = {
      if (bis.available() <= 0) {
        severe("no else available")
        for (i <- a.indices) a(i) = 0
        -1
      } else {
        val r = bis.read(a)
        info("Read " + r + " bytes")
        if (bis.available() <= 0) warn("no else available")
        r
      }
    }
  }

  trait Logger {
    def log(msg: String)
    def info(msg: String) {log("INFO: " + msg)}
    def warn(msg: String) {log("WARN: " + msg)}
    def severe(msg: String) {log("SEVERE: " + msg)}
  }
}
