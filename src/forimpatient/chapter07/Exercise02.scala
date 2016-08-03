package forimpatient.chapter07.next

/**
  * Created by Iryna Kharaborkina on 8/3/16.
  *
  * Solution to the Chapter 07 Exercise 02 'Scala for the Impatient' by Horstmann C.S.
  *
  * Write a puzzler that baffles your Scala friends, using a package com that isn’t at the top level.
  */

  object Exercise02 extends App {
    println("Chapter 07 Exercise 02")
    val amy = new Manager("Amy", new forimpatient.chapter07.com.horstmann.Salary(90000)) // com.horstmann does not work
    println(amy.name)
    println(amy.salary.amount)
  }

  class Manager(val name: String, val salary: forimpatient.chapter07.com.horstmann.Salary) // com.horstmann does not work

package com {
}
