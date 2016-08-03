package forimpatient.chapter05

/**
  * Created by Iryna Kharaborkina on 8/3/16. 
  *
  * Solution to the Chapter 05 Exercise 06 'Scala for the Impatient' by Horstmann C.S.
  *
  * In the Person class of Section 5.1, “Simple Classes and Parameterless Methods,” on page 49,
  * provide a primary constructor that turns negative ages to 0.
  */
object Exercise06 extends App {
  println("Chapter 05 Exercise 06")
  val fred = new Person(42)
  val amy = new Person(-2)

  println(fred.age)
  println(amy.age)

  class Person(var age: Int) {
    if (age < 0) age = 0
  }
}
