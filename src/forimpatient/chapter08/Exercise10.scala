package forimpatient.chapter08

import scala.collection.immutable.Stack

/**
  * Created by Iryna Kharaborkina on 8/6/16. 
  *
  * Solution to the Chapter 08 Exercise 10 'Scala for the Impatient' by Horstmann C.S.
  *
  * The file scala/collection/immutable/Stack.scala contains the definition
  *     class Stack[A] protected (protected val elems: List[A])
  * Explain the meanings of the protected keywords. (Hint: Review the discussion of private
  * constructors in Chapter 5.)
  */
object Exercise10 extends App {
  println("Chapter 08 Exercise 10")

  val childStack = new ChildStack[Int]((1 to 10).toList) // can use constructor
  println(childStack)

  // val stack = new Stack[Int]((1 to 10).toList) No such constructor
  val stack = new Stack[Int]()
  stack.push(1)
  println(stack)

  class ChildStack[A](elems: List[A]) extends Stack[A](elems: List[A])
}
