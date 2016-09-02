package forimpatient.chapter19

import scala.util.parsing.combinator.RegexParsers

/**
  * Created by Iryna Kharaborkina on 8/29/16. 
  *
  * Solution to the Chapter 19 Exercise 01 'Scala for the Impatient' by Horstmann C.S.
  * Add / and % operations to the arithmetic expression evaluator.
  */
object Exercise01 extends App {
  println("Chapter 19 Exercise 01")

  val parser = new ExprParser
  val result = parser.parseAll(parser.expr, "52 / 2 % 9 / 4 - 2 - 4")
  if (result.successful) println(result.get)


  class ExprParser extends RegexParsers {
    val number = "[0-9]+".r

    def expr: Parser[Int] = term ~ rep(("+" | "-") ~ term ^^ {
      case "+" ~ t => t
      case "-" ~ t => -t
    }) ^^ {case t ~ r => t + r.sum}

    def term: Parser[Int] = factor ~ rep(("*" | "/" | "%") ~ factor) ^^ {
      case f ~ r => r.foldLeft(f)((n, pair) => pair._1 match {
          case "*" => n * pair._2;
          case "/" => n / pair._2
          case "%" => n % pair._2
        })
    }

    def factor: Parser[Int] = number ^^ (_.toInt)| "(" ~> expr <~ ")"
  }
}
