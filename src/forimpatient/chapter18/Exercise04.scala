package forimpatient.chapter18

import scala.collection.mutable.ArrayBuffer

/**
  * Created by Iryna Kharaborkina on 8/29/16. 
  *
  * Solution to the Chapter 18 Exercise 04 'Scala for the Impatient' by Horstmann C.S.
  *
  * Implement the equals method for the Member class that is nested inside the Network class in Section 18.2,
  * “Type Projections,” on page 247. For two members to be equal, they need to be in the same network.
  */
object Exercise04 extends App {
  println("Chapter 18 Exercise 04")

  val chatter = new Network
  val myFace = new Network
  val fred = chatter.join("Fred")
  val anotherFred = chatter.join("Fred")
  val wilma = chatter.join("Wilma")
  val barney = myFace.join("Barney")
  val myFaceFred = myFace.join("Fred")

  println(fred.equals(wilma))
  println(fred.equals(barney))
  println(fred.equals(anotherFred))
  println(fred.equals(myFaceFred))

  class Network {
    class Member(val name: String) {
      val contacts = new ArrayBuffer[Network#Member]

      override def equals(other: Any): Boolean = other match {
        case other: Member => name.equals(other.name)
        case _ => false
      }
      override def toString: String = getClass.getSimpleName + "[" + name + "]"
    }

    private val members = new ArrayBuffer[Member]

    def join(name: String) = {
      val m = new Member(name)
      members += m
      m
    }
  }
}
