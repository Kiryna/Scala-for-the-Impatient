package forimpatient.chapter14

/**
  * Created by Iryna Kharaborkina on 8/12/16. 
  *
  * Solution to the Chapter 14 Exercise 08 'Scala for the Impatient' by Horstmann C.S.
  *
  * Extend the tree in the preceding exercise so that each non-leaf node stores an operator in addition to the child nodes.
  * Then write a function eval that computes the value. For example, the tree
  *       +
  *      /|\
  *     * 2 -
  *    / \  |
  *   3  8  5
  * has value (3 × 8) + 2 + (–5) = 21.
  */
object Exercise08 extends App {
  println("Chapter 14 Exercise 08")

  println(leafSum(Node('+', Node('*', Leaf(3), Leaf(8)), Leaf(2), Node('-', Leaf(5)))))

  def leafSum(tree: Tree): Int = tree match {
    case Node('+', lst @ _*) => lst.map(leafSum).sum
    case Node('*', lst @ _*) => lst.map(leafSum).product
    case Node('-', lst @ _*) => lst.map(leafSum).foldLeft(0)(_ - _)
    case Leaf(v) => v
    case _ => 0
  }

  sealed abstract class Tree
  case class Leaf(value: Int) extends Tree
  case class Node(op: Char, children: Tree *) extends Tree
}
