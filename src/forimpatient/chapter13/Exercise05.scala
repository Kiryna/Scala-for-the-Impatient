package forimpatient.chapter13

/**
  * Created by Iryna Kharaborkina on 7/25/16. 
  *
  * Solution to the Chapter 13 Exercise 05 'Scala for the Impatient' by Horstmann C.S.
  *
  * Implement a function that works just like mkString, using reduceLeft.
  */
object Exercise05 extends App {
  println(mkString(1 to 10, "<", " and ", ">"))
  println(mkString('a' to 'z', "[", " - ", "]"))

  def mkString(seq: Seq[Any], start: String, del: String, end: String) = start + seq.reduceLeft(_ + del + _) + end
}
