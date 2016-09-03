package forimpatient.chapter19

import scala.util.parsing.combinator.RegexParsers

/**
  * Created by Iryna Kharaborkina on 9/3/16. 
  *
  * Solution to the Chapter 19 Exercise 03 'Scala for the Impatient' by Horstmann C.S.
  *
  * Write a parser that parses a list of integers (such as (1, 23, -79)) into a List[Int].
  */
object Exercise03 extends App {
  println("Chapter 19 Exercise 03")

  val parser = new NumberListParser
  val result = parser.parseAll(parser.numberList, "(1, 23, -79, 8, -1, 02, -9)")
  if (result.successful) println(result.get)

  class NumberListParser extends RegexParsers {
    val number = "-?[0-9]+".r

    def numberList: Parser[List[Int]] = "(" ~> repsep(number ^^ (_.toInt), ",") <~ ")"
  }

}
