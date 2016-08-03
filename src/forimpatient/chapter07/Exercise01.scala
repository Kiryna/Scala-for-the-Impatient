package forimpatient.chapter07


/**
  * Created by Iryna Kharaborkina on 8/3/16. 
  *
  * Solution to the Chapter 07 Exercise 01 'Scala for the Impatient' by Horstmann C.S.
  *
  * Write an example program to demonstrate that
  *   package com.horstmann.impatient
  * is not the same as
  *   package com
  *   package horstmann
  *   package impatient
  */
object Exercise01 extends App {
  println("Chapter 07 Exercise 01")

  import com.horstmann.impatient._
  import com.horstmann.Salary

  val fred = new Person("Fred")
  val amy = new Employee("Amy", new Salary(50000), "Programmer")
  val james = new Manager("James", new Salary(60000))

  println(fred.name)

  println(amy.name)
  println(amy.salary.amount)
  println(amy.position)

  println(james.name)
  println(james.salary.amount)
  println(james.position)
}

package com.horstmann.impatient {
  class Person(val name: String)
  class Employee(name: String, val salary: com.horstmann.Salary, val position: String) extends Person(name: String)
}

package com {
  package horstmann {
    class Salary(val amount: Double)
    package impatient {
      class Manager(name: String, salary: Salary) extends Employee(name: String, salary: Salary, position = "Manager")
    }
  }
}
