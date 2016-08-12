package forimpatient.chapter14

import forimpatient.chapter14.Exercise06.{Leaf, Node}

/**
  * Created by Iryna Kharaborkina on 8/12/16. 
  *
  * Solution to the Chapter 14 Exercise 07 'Scala for the Impatient' by Horstmann C.S.
  *
  * Extend the tree in the preceding exercise so that each node can have an arbitrary number of children,
  * and reimplement the leafSum function. The tree in exercise 5 should be expressible as
  *     Node(Node(Leaf(3), Leaf(8)), Leaf(2), Node(Leaf(5)))
  */
object Exercise07 extends App {
  println("Chapter 14 Exercise 07")

  println(leafSum(Node(Node(Leaf(3), Leaf(8)), Leaf(2), Node(Leaf(5)))))

  def leafSum(tree: Tree): Int = tree match {
    case Node(lst @ _*) => lst.map(leafSum).sum
    case Leaf(v) => v
    case _ => 0
  }

  sealed abstract class Tree
  case class Leaf(value: Int) extends Tree
  case class Node(children: Tree *) extends Tree

}
