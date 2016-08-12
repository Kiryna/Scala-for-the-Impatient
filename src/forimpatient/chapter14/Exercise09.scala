package forimpatient.chapter14

/**
  * Created by Iryna Kharaborkina on 8/12/16. 
  *
  * Solution to the Chapter 14 Exercise 09 'Scala for the Impatient' by Horstmann C.S.
  *
  * Write a function that computes the sum of the non-None values in a List[Option[Int]]. Don’t use a match statement.
  */
object Exercise09 extends App {
  println("Chapter 14 Exercise 09")

  println(sum(List(Some(2), None, Some(3))))

  def sum(lst: List[Option[Int]]) = lst.filter(_.isDefined).map(_.get).sum
}
