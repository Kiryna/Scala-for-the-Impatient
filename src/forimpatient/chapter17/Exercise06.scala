package forimpatient.chapter17

/**
  * Created by Iryna Kharaborkina on 8/24/16. 
  *
  * Solution to the Chapter 17 Exercise 06 'Scala for the Impatient' by Horstmann C.S.
  *
  * Write a generic method middle that returns the middle element from any Iterable[T].
  * For example, middle("World") is 'r'.
  */
object Exercise06 extends App {

  println(middle("World"))
  println(middle(1 to 10))

  def middle[T](it: Iterable[T]) = it.toList(it.size / 2)
}
