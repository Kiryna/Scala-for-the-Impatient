package forimpatient.chapter19

import scala.collection.mutable.Map
import scala.util.parsing.combinator.syntactical.StandardTokenParsers

/**
  * Created by Iryna Kharaborkina on 9/3/16. 
  *
  * Solution to the Chapter 19 Exercise 08 'Scala for the Impatient' by Horstmann C.S.
  *
  * Add variables and assignment to the calculator program. Variables are created when they are first used.
  * Uninitialized variables are zero. To print a value, assign it to the special variable out.
  */
object Exercise08 extends App {
  println("Chapter 19 Exercise 08")

  val parser = new ExprParser
  val result = parser.parseAll(parser.program, "a = 3 - 4 - 5; out = b; b = a + 1; out = b; out = 5 * 2 ^ 3")


  class ExprParser extends StandardTokenParsers {
    lexical.delimiters += ("+", "-", "*", "(", ")", ";", "%", "/", "^", "=")

    val number = numericLit
    val varName = ident
    val variables = Map[String, Int]()

    def parseAll[T](p: Parser[T], in: String): ParseResult[T] = phrase(p)(new lexical.Scanner(in))

    def program: Parser[Any] = rep(statement)

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

    def factor: Parser[Int] = number ^^ (_.toInt)| "(" ~> expr <~ ")" | variable

    def variable: Parser[Int] = varName ^^ {
      v => variables.getOrElse(v, 0)
    }

    def statement: Parser[Any] = varName ~ ("=" ~> expr <~ opt(";")) ^^ {
      case "out" ~ e => println(e)
      case v ~ e => variables(v) = e
    } | expr
  }
}
