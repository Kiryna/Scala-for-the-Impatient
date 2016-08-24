package forimpatient.chapter17

/**
  * Created by Iryna Kharaborkina on 8/24/16. 
  *
  * Solution to the Chapter 17 Exercise 04 'Scala for the Impatient' by Horstmann C.S.
  *
  * Why don’t we need a lower bound for the replaceFirst method in Section 17.3, “Bounds for Type Variables,”
  * on page 232 if we want to replace the first component of a Pair[Person] with a Student?
  */
object Exercise04 extends App {
  println("Chapter 17 Exercise 04")

  private val person = new Person
  private val student = new Student

  val personsPair = new Pair[Person](person, student)
  val studentsPair = new Pair[Student](student, student)

  val pairOne: Pair[Person] =personsPair.replaceFirst(student)
  val pairTwo: Pair[Person] = studentsPair.replaceFirst(person)

  println(pairOne)
  println(pairTwo)


  class Pair[T](val first: T, val second: T) {
    def replaceFirst[R >: T](newFirst: R) = new Pair[R](newFirst, second)

    override def toString: String = getClass.getSimpleName + "[" + first + " -> " + second + "]"
  }

  class Person {
    override def toString: String = getClass.getSimpleName
  }
  class Student extends Person
}
