package forimpatient.chapter19

import forimpatient.chapter19.Exercise06.Operator

import scala.util.parsing.combinator.RegexParsers

/**
  * Created by Iryna Kharaborkina on 9/3/16. 
  *
  * Solution to the Chapter 19 Exercise 07 'Scala for the Impatient' by Horstmann C.S.
  *
  * Suppose in Section 19.6, “Avoiding Left Recursion,” on page 276, we first parse an expr into a list of ~
  * with operations and values:
  *     def expr: Parser[Int] = term ~ rep(("+" | "-") ~ term) ^^ {...}
  * To evaluate the result, we need to compute ((t0 ± t1) ± t2) ± . . . Implement this computation as a fold
  */
object Exercise07 extends App {
  println("Chapter 19 Exercise 07")

  val parser = new ExprParser
  val result = parser.parseAll(parser.expr, "3-4-5-6")
  if (result.successful) println(result.get)

  class ExprParser extends RegexParsers {
    val number = "[0-9]+".r

    def expr: Parser[Int] = term ~ rep(("+" | "-") ~ term) ^^ {
      case t ~ r => r.foldLeft(t)((previous, current) => current._1 match {
        case "+" => previous + current._2
        case "-" => previous - current._2
      })
    }

    def term: Parser[Int] = factor ~ rep("*" ~> factor) ^^ {
      case f ~ r => f * r.product
    }

    def factor: Parser[Int] = number ^^ (_.toInt) | "(" ~> expr <~ ")"
  }

}
