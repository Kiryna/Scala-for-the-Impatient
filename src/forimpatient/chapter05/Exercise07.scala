package forimpatient.chapter05

/**
  * Created by Iryna Kharaborkina on 8/3/16. 
  *
  * Solution to the Chapter 05 Exercise 07 'Scala for the Impatient' by Horstmann C.S.
  *
  * Write a class Person with a primary constructor that accepts a string containing a first name, a space,
  * and a last name, such as new Person("Fred Smith"). Supply read-only properties firstName and lastName.
  * Should the primary constructor parameter be a var, a val, or a plain parameter? Why?
  */
object Exercise07 extends App {
  println("Chapter 05 Exercise 07")

  val a = new Person("Fred  Smith")
  println(a.firstName)
  println(a.lastName)

  val b = new Person("Amy")
  println(b.firstName)
  println(b.lastName)

  val c = new Person("")
  println(c.firstName)
  println(c.lastName)

  class Person(name: String) {
    val (firstName, lastName) =  name.split("\\s+") match {
      case Array(f, l, _*) => (f, l)
      case Array(f) =>
        val unknown: String = "n/a"
        if (!f.isEmpty) (f, unknown) else (unknown, unknown)
    }
  }
}
