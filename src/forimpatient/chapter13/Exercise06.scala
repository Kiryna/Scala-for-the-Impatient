package forimpatient.chapter13

/**
  * Created by Iryna Kharaborkina on 8/9/16. 
  *
  * Solution to the Chapter 13 Exercise 06 'Scala for the Impatient' by Horstmann C.S.
  *
  * Given a list of integers lst, what is (lst :\ List[Int]())(_ :: _)? (List[Int]() /: lst)(_ :+ _)?
  * How can you modify one of them to reverse the list?
  */
object Exercise06 extends App {
  println("Chapter 13 Exercise 06")

  val lst = (1 to 10).toList
  println((lst :\ List[Int]())(_ :: _ ))
  println(lst.foldRight(List[Int]())(_ :: _))

  println((List[Int]() /: lst)(_ :+ _ ))
  println(lst.foldLeft(List[Int]())(_ :+ _))

  println((List[Int]() /: lst)((x, y) => y +: x))
}
