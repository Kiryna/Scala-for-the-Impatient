package forimpatient.chapter18

/**
  * Created by Iryna Kharaborkina on 8/29/16. 
  *
  * Solution to the Chapter 18 Exercise 10 'Scala for the Impatient' by Horstmann C.S.
  *
  * Self types can usually be replaced with traits that extend classes, but there can be situations
  * where using self types changes the initialization and override orders. Construct such an example.
  */
object Exercise10 extends App {
  println("Chapter 18 Exercise 10")

  class N {
    def name = "I am class N"
    def hello(): String = "Hello! " + name
  }

  trait A {
    self: N=>
    override val name: String = "" + self.name + " and I am a trait A"
  }

  trait B extends N {
    override val name: String = "" + super.name + " and I am a trait B"
  }

  class D extends N {
    override val name: String = "" + super.name + " and I am a class D"
  }

  val one = new D with A
  val two = new D with B

  println(one.hello())
  println(two.hello())
}
