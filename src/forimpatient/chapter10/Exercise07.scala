package forimpatient.chapter10

import scala.collection.mutable.ArrayBuffer

/**
  * Created by Iryna Kharaborkina on 8/8/16. 
  *
  * Solution to the Chapter 10 Exercise 07 'Scala for the Impatient' by Horstmann C.S.
  *
  * There are dozens of Scala trait tutorials with silly examples of barking dogs or philosophizing frogs.
  * Reading through contrived hierarchies can be tedious and not very helpful, but designing your own
  * is very illuminating. Make your own silly trait hierarchy example that demonstrates layered traits,
  * concrete and abstract methods, and concrete and abstract fields.
  */
object Exercise07 extends App {
  println("Chapter 10 Exercise 07")

  val john = new Employee("John") with WorkLogger {
    override def msg: String = "I am working"
  }
  john.log()

  val lucy = new Employee("Lucy") with WorkLogger {
    override def msg: String = "I am on vacation"
  }
  lucy.log()

  val any = new Manager("Any") with WorkLogger {
    override def msg: String = "I am managing"
  }

  any.addEmployee(john)
  any.addEmployee(lucy)
  any.log()

  trait WorkLogger {
    def msg: String
    def log() = println(this + " : " + msg)
  }

  class Manager(name: String) extends Employee(name: String) {
    val employees = ArrayBuffer[Employee]()
    def addEmployee(employee: Employee): Unit = {
      employees += employee
    }
    override def toString: String =
      "I am " + name + ", the manager of " + employees.map(_.name).mkString("<", " and ", ">")
  }

  class Employee(val name: String) {
    override def toString: String = "I am " + name
  }

}
