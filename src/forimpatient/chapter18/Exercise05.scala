package forimpatient.chapter18

import scala.collection.mutable.ArrayBuffer

/**
  * Created by Iryna Kharaborkina on 8/29/16. 
  *
  * Solution to the Chapter 18 Exercise 05 'Scala for the Impatient' by Horstmann C.S.
  *
  * Consider the type alias
  *       type NetworkMember = n.Member forSome { val n: Network }
  * and the function
  *       def process(m1: NetworkMember, m2: NetworkMember) = (m1, m2)
  * How does this differ from the process function in Section 18.8, “Existential Types,” on page 252?
  */
object Exercise05 extends App {
  println("Chapter 18 Exercise 05")

  val chatter = new Network
  val myFace = new Network
  val fred = chatter.join("Fred")
  val wilma = chatter.join("Wilma")
  val barney = myFace.join("Barney")

  println(process(fred, wilma))
  println(process(fred, barney))

  type NetworkMember = n.Member forSome { val n: Network }
  def process(m1: NetworkMember, m2: NetworkMember) = (m1, m2)

  class Network {
    class Member(val name: String) {
      val contacts = new ArrayBuffer[Network#Member]

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
