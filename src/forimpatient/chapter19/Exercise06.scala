package forimpatient.chapter19

import scala.util.parsing.combinator.RegexParsers

/**
  * Created by Iryna Kharaborkina on 9/3/16. 
  *
  * Solution to the Chapter 19 Exercise 06 'Scala for the Impatient' by Horstmann C.S.
  *
  * Assume that the parser in Section 19.5, “Generating Parse Trees,” on page 275 is completed with
  *     class ExprParser extends RegexParsers {
  *         def expr: Parser[Expr] = (term ~ opt(("+" | "-") ~ expr)) ^^ {
  *             case a ~ None => a
  *             case a ~ Some(op ~ b) => Operator(op, a, b)
  *         }
  *         ...
  *     }
  * Unfortunately, this parser computes an incorrect expression tree—operators with the same precedence
  * are evaluated right-to-left. Modify the parser so that the expression tree is correct.
  * For example, 3-4-5 should yield an Operator("-", Operator("-", 3, 4), 5).
  */
object Exercise06 extends App {
  println("Chapter 19 Exercise 06")

  val parser = new ExprParser
  val result = parser.parseAll(parser.expr, "3 - 4 - 5")
  if (result.successful) println(result.get)

  class ExprParser extends RegexParsers {
    val number = "[0-9]+".r

    def expr: Parser[Expr] = term ~ rep(("+" | "-") ~ term) ^^ {
      case t ~ r => r.foldLeft(t)((previous, current) => Operator(current._1, previous, current._2))
    }

    def term: Parser[Expr] = factor ~ opt("*" ~> factor) ^^ {
      case a ~ None => a
      case a ~ Some(b) => Operator("*", a, b)
    }

    def factor: Parser[Expr] = number ^^ (n => Number(n.toInt)) | "(" ~> expr <~ ")"
  }

  class Expr
  case class Operator(op: String, left: Expr, right: Expr) extends Expr
  case class Number(value: Int) extends Expr {
    override def toString: String = value.toString
  }

}
