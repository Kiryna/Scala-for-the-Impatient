package forimpatient.chapter14

/**
  * Created by Iryna Kharaborkina on 8/12/16. 
  *
  * Solution to the Chapter 14 Exercise 06 'Scala for the Impatient' by Horstmann C.S.
  *
  * A better way of modeling such trees is with case classes. Let’s start with binary trees.
  *     sealed abstract class BinaryTree
  *     case class Leaf(value: Int) extends BinaryTree
  *     case class Node(left: BinaryTree, right: BinaryTree) extends BinaryTree
  * Write a function to compute the sum of all elements in the leaves.
  */
object Exercise06 extends App {
  println("Chapter 14 Exercise 06")

  println(leafSum(Node(Node(Leaf(3), Leaf(8)),  Node(Leaf(2),  Node(Leaf(5), null)))))

  def leafSum(tree: BinaryTree): Int = tree match {
    case Node(l, r) => leafSum(l) + leafSum(r)
    case Leaf(v) => v
    case _ => 0
  }

  sealed abstract class BinaryTree
  case class Leaf(value: Int) extends BinaryTree
  case class Node(left: BinaryTree, right: BinaryTree) extends BinaryTree
}
