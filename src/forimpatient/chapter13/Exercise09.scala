package forimpatient.chapter13

import java.util.concurrent.atomic.AtomicInteger

import scala.io.Source
import scala.collection.JavaConversions.mapAsScalaConcurrentMap

/**
  * Created by Iryna Kharaborkina on 8/9/16. 
  *
  * Solution to the Chapter 13 Exercise 09 'Scala for the Impatient' by Horstmann C.S.
  *
  * Harry Hacker writes a program that accepts a sequence of file names on the command line. For each,
  * he starts a new thread that reads the file and updates a letter frequency map, declared as
  *       val frequencies = new scala.collection.mutable.HashMap[Char, Int] with
  *           scala.collection.mutable.SynchronizedMap[Char, Int]
  * When reading a letter c, he calls
  *       frequencies(c) = frequencies.getOrElse(c, 0) + 1
  * Why won’t this work? Will it work if he used instead
  *       import scala.collection.JavaConversions.asScalaConcurrentMap
  *       val frequencies: scala.collection.mutable.ConcurrentMap[Char, Int] =
  *           new java.util.concurrent.ConcurrentHashMap[Char, Int]
  */
object Exercise09 extends App {
  println("Chapter 13 Exercise 09")

  val frequencies: scala.collection.concurrent.Map[Char, AtomicInteger] = new java.util.concurrent.ConcurrentHashMap[Char, AtomicInteger]()

  val files = Array("src/forimpatient/chapter13/1.txt", "src/forimpatient/chapter13/2.txt")
  var nonProceeded = files.size

  for (file <- files) {
    new Thread(new Runnable {
      override def run(): Unit = {
        val chars = Source.fromFile(file).iter
        for (c <- chars) { frequencies.putIfAbsent(c, new AtomicInteger(0)); frequencies(c).incrementAndGet()}
        nonProceeded -= 1
        if (nonProceeded == 0) println(frequencies)
      }
    }).start()
  }
}
