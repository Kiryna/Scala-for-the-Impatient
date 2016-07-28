package forimpatient.chapter03

import scala.collection.mutable.ArrayBuffer

/**
  * Created by Iryna Kharaborkina on 7/28/16. 
  *
  * Solution to the Chapter 03 Exercise 08 'Scala for the Impatient' by Horstmann C.S.
  *
  * Rewrite the example at the end of Section 3.4, “Transforming Arrays,” on page 32. Collect
  * indexes of the negative elements, reverse the sequence, drop the last index, and call a.remove(i)
  * for each index. Compare the efficiency of this approach with the two approaches in Section 3.4.
  */
object Exercise08 extends App {
  println("Chapter 03 Exercise 08")

  val a = ArrayBuffer(5, -2, 3, 4, 0, 7, 1, -5, 9, -7, 0, 4, -4, -9, 1)

  val indices = (for (i <- a.indices  if a(i) < 0)  yield i).reverse.dropRight(1)
  for (i <- indices) a.remove(i)

  println(a)
}
