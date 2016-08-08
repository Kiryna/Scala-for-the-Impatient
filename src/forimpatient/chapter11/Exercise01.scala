package forimpatient.chapter11

/**
  * Created by Iryna Kharaborkina on 8/8/16. 
  *
  * Solution to the Chapter 11 Exercise 01 'Scala for the Impatient' by Horstmann C.S.
  *
  * According to the precedence rules, how are 3 + 4 -> 5 and 3 -> 4 + 5 evaluated?
  */
object Exercise01 extends App {
  println("the Chapter 11 Exercise 01")

  // First from left to right
  println(3 + 4 -> 5)

  // Second is incorrect as 3 -> 4 produce Tuple2 and + is not defined, can be fixed such as
  println(3 -> (4 + 5))
}
