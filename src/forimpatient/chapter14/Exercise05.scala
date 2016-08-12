package forimpatient.chapter14

/**
  * Created by Iryna Kharaborkina on 8/11/16. 
  *
  * Solution to the Chapter 14 Exercise 05 'Scala for the Impatient' by Horstmann C.S.
  *
  * One can use lists to model trees that store values only in the leaves.
  * For example, the list ((3 8) 2 (5)) describes the tree
  *     •
  *    /|\
  *   • 2 •
  *  / \  |
  * 3   8 5
  *
  * However, some of the list elements are numbers and others are lists. In Scala, you cannot have heterogeneous lists,
  * so you have to use a List[Any]. Write a leafSum function to compute the sum of all elements in the leaves,
  * using pattern matching to differentiate between numbers and lists.
  */
object Exercise05 extends App {
  println("Chapter 14 Exercise 05")

  println(leafSum(List(List(3, 8),  2,  List(5))))
  println(leafSum(List(2, List(List(3, 8),  2,  List(5)), 5, List(1, 7), 9)))
  println(leafSum(List()))

  def leafSum(lst: List[Any]): Int = lst.map {
    case x: List[Any] => leafSum(x)
    case x: Int => x
    case _ => 0
  }.sum
}
