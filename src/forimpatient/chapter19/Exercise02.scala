package forimpatient.chapter19

import scala.util.parsing.combinator.RegexParsers

/**
  * Created by Iryna Kharaborkina on 9/3/16. 
  *
  * Solution to the Chapter 19 Exercise 02 'Scala for the Impatient' by Horstmann C.S.
  *
  * Add a ^ operator to the arithmetic expression evaluator. As in mathematics, ^ should have a higher precedence
  * than multiplication, and it should be right-associative. That is, 4^2^3 should be 4^(2^3), or 65536.
  */
object Exercise02 extends App {
  println("Chapter 19 Exercise 02")

  val parser = new ExprParser
  val result = parser.parseAll(parser.expr, "(2*2)^2^(2+1)")
  if (result.successful) println(result.get)


  class ExprParser extends RegexParsers {
    val number = "[0-9]+".r

    def expr: Parser[Int] = term ~ rep(("+" | "-") ~ term ^^ {
      case "+" ~ t => t
      case "-" ~ t => -t
    }) ^^ {case t ~ r => t + r.sum}

    def term: Parser[Int] = pow ~ rep(("*" | "/" | "%") ~ pow) ^^ {
      case f ~ r => r.foldLeft(f)((n, pair) => pair._1 match {
        case "*" => n * pair._2;
        case "/" => n / pair._2
        case "%" => n % pair._2
      })
    }

    def pow: Parser[Int] = rep(factor <~ "^") ~ factor ^^ {
      case r ~ f => r.foldRight(f)(math.pow(_, _).toInt)
    }

    def factor: Parser[Int] = number ^^ (_.toInt)| "(" ~> expr <~ ")"
  }

}
