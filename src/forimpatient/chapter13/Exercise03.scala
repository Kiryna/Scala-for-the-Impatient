package forimpatient.chapter13

import scala.collection.mutable.LinkedList

/**
  * Created by Iryna Kharaborkina on 7/25/16. 
  *
  * Solution to the Chapter13 Exercise 03 'Scala for the Impatient' by Horstmann C.S.
  *
  * Write a function that removes all zeroes from a linked list of integers.
  */
object Exercise03 extends App {
  val lstOne = LinkedList[Int](0, 1, 2, 4, 0, 0, 4, 8, 0, 1, 0, 1, 5, 7, 0)
  println(lstOne)
  removeZeros(lstOne)
  println(lstOne)

  val lstTwo = LinkedList[Int](0)
  println(lstTwo)
  removeZeros(lstTwo)
  println(lstTwo)

  val lstThree = LinkedList[Int]()
  println(lstThree)
  removeZeros(lstThree)
  println(lstThree)

  def removeZeros(lst: LinkedList[Int]): Unit = {
    var tmp = lst
    while (tmp != Nil ) {
      if (tmp.elem == 0 && tmp.next == Nil) tmp.next = tmp
      else if (tmp.elem == 0) {
        tmp.elem = tmp.next.elem
        tmp.next = tmp.next.next
      }
      if (tmp.elem != 0) tmp = tmp.next
    }

  }
}
