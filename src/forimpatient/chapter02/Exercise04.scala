package forimpatient.chapter02

/**
  * Created by Iryna Kharaborkina on 7/25/16. 
  *
  * Solution to the Chapter 02 Exercise 04 'Scala for the Impatient' by Horstmann C.S.
  *
  * Write a Scala equivalent for the Java loop
  *     for (int i = 10; i >= 0; i--) System.out.println(i);
  */
object Exercise04 extends App {
  println("Chapter 02 Exercise 04")
  for (i <- 10 to (0, -1)) println(i)
}
