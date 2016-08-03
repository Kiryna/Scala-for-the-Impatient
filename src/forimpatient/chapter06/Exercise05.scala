package forimpatient.chapter06

/**
  * Created by Iryna Kharaborkina on 8/3/16. 
  *
  * Solution to the Chapter 06 Exercise 05 'Scala for the Impatient' by Horstmann C.S.
  *
  * Write a Scala application, using the App trait, that prints the command-line arguments in reverse order,
  * separated by spaces. For example, scala Reverse Hello World should print World Hello.
  */
object Exercise05 extends App {
  println("Chapter 06 Exercise 05")
  println(args.reverse.mkString(" "))
}
