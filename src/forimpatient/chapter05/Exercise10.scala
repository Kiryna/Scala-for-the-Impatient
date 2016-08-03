package forimpatient.chapter05

/**
  * Created by Iryna Kharaborkina on 8/3/16. 
  *
  * Solution to the forimpatient.chapter05 Exercise 10 'Scala for the Impatient' by Horstmann C.S.
  *
  * Consider the class
  *   class Employee(val name: String, var salary: Double) {
  *     def this() { this("John Q. Public", 0.0) }
  *   }
  *   Rewrite it to use explicit fields and a default primary constructor. Which form do you prefer? Why?
  */
object Exercise10 extends App {
  println("Chapter 05 Exercise 10")

  val john = new Employee()
  println(john.name)
  println(john.salary)

  val fred = new Employee("Fred Smith", 10)
  println(fred.name)
  println(fred.salary)

  class Employee() {
    var name: String = "John Q. Public"
    var salary: Double = 0.0

    def this(name: String, salary: Double) {
      this()
      this.name = name
      this.salary = salary
    }
  }

}
