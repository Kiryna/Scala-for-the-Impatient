package forimpatient.chapter09

import java.io.File

/**
  * Created by Iryna Kharaborkina on 8/7/16. 
  *
  * Solution to the Chapter 09 Exercise 09 'Scala for the Impatient' by Horstmann C.S.
  *
  * Write a Scala program that counts how many files with .class extension are in a given directory
  * and its subdirectories.
  */
object Exercise09 extends App {
  println("Chapter 09 Exercise 09")

  val dir = new File("out")
  println(countClasses(dir))

  def countClasses(dir: File):Int = {
    def isClassFile: (File) => Boolean = x => x.getName.contains(".class") && x.isFile
    dir.listFiles.count(isClassFile) + dir.listFiles.filter(_.isDirectory).map(countClasses).sum
  }
}
