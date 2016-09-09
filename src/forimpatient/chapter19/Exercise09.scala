package forimpatient.chapter19

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer
import scala.io.Source
import scala.util.parsing.combinator.syntactical.StandardTokenParsers

/**
  * Created by Iryna Kharaborkina on 9/8/16. 
  *
  * Solution to the Chapter 19 Exercise 09 'Scala for the Impatient' by Horstmann C.S.
  *
  * Extend the preceding exercise into a parser for a programming language that has variable assignments,
  * Boolean expressions, and if/else and while statements.
  */
object Exercise09 extends App {
  println("Chapter 19 Exercise 09")

  val parser = new ExprParser
  val program = Source.fromFile("src/forimpatient/chapter19/program_01.mylng").mkString
  val result = parser.parseAll(parser.program, program)

  class ExprParser extends StandardTokenParsers {
    import Arithmetic._

    lexical.delimiters += ("+", "-", "*", "(", ")", ";", "%", "/", "^", "=", "==", "!=", ">=", "<=", ">", "<", "{", "}")
    lexical.reserved += ("if", "else", "while")

    val number = numericLit
    val varName = ident
    val variables = mutable.Map[String, Int]()

    def parseAll[T](p: Parser[T], in: String): ParseResult[T] = phrase(p)(new lexical.Scanner(in))

    def program: Parser[Any] = repeatedStatements ^^ {
      _.foreach(_.execute())
    }

    def expr: Parser[Expr] = term ~ rep(("+" | "-") ~ term) ^^ {
      case t ~ r => r.foldLeft(t)((previous, current) => Operator(current._1 match {
        case "+" => sum
        case "-" => diff
      }, previous, current._2))
    }

    def term: Parser[Expr] = pow ~ rep(("*" | "/" | "%") ~ pow) ^^ {
      case f ~ r => r.foldLeft(f)((n, pair) => Operator(pair._1 match {
        case "*" => prod
        case "/" => div
        case "%" => mod
      }, n, pair._2))
    }

    def pow: Parser[Expr] = rep(factor <~ "^") ~ factor ^^ {
      case r ~ f => r.foldRight(f)((l, r) => Operator(intPow, l, r))
    }

    def factor: Parser[Expr] = number ^^ (n => Number(n.toInt)) | "(" ~> expr <~ ")" | variable

    def variable: Parser[Expr] = varName ^^ {
      v => Variable(v)
    }

    def control: Parser[Control] = ("if" | "while") ~ boolean ~ repeatedStatements ~
      opt("else" ~> repeatedStatements) ^^ {
      case "if" ~ b ~ st ~ expr => Control(b, "if", st, expr)
      case "while" ~ b ~ st ~ _ => Control(b, "while", st)
    }

    def assignment: Parser[Assignment] = varName ~ ("=" ~> expr <~ opt(";")) ^^ {
      case v ~ e => Assignment(v, e)
    }

    def repeatedStatements: Parser[List[Statement]] = (opt("{") ~>rep(control | assignment) <~ opt("}")) ^^ {
      r => {val statements = ArrayBuffer[Statement](); for (s <- r) s match {
        case st: Statement => statements += st
        case l: List[Statement] => statements ++= l
      }
      statements.toList}
    }

    def boolean: Parser[Bool] = opt("(") ~> (expr ~ comparison ~ expr) <~ opt(")") ^^ {
      case a ~ fun ~ b => Bool(fun, a, b)
    }

    def comparison: Parser[(Expr, Expr) => Boolean] = ("==" | "!=" | ">=" | "<=" | ">" | "<") ^^ {
      case "==" => Comparisons.==
      case "!=" => Comparisons.!=
      case ">=" => Comparisons.>=
      case "<=" => Comparisons.<=
      case ">"  => Comparisons.>
      case "<"  => Comparisons.<
    }

    abstract class Statement {
      def execute(): Unit
    }

    case class Assignment(varName: String, varValue: Expr) extends Statement {
      def execute(): Unit = {
        val v = varValue.value
        varName match {
          case "out" => println(v)
          case _ => variables(varName) = v
        }
      }
    }

    case class Control(bool: Bool, op: String, left: List[Statement],
                       right: Option[List[Statement]] = None) extends Statement {
      def execute(): Unit = op match {
        case "if" => if (bool.bool) left.foreach(_.execute()) else if (right.isDefined) right.get.foreach(_.execute())
        case "while" => while (bool.bool) left.foreach(_.execute())
      }
    }

    class Expr {
      def value: Int = 0
    }

    case class Bool(op: (Expr, Expr) => Boolean, left: Expr, right: Expr) extends Expr {
      def bool: Boolean = op(left, right)
    }

    case class Operator(op: (Expr, Expr) => Int, left: Expr, right: Expr) extends Expr {
      override def value: Int = op(left, right)
    }

    case class Variable(name: String) extends Expr {
      override def value: Int = variables.getOrElse(name, 0)
    }

    case class Number(override val value: Int) extends Expr {
      override def toString: String = value.toString
    }

    object Arithmetic {
      val sum = (a: Expr, b: Expr) => a.value + b.value
      val diff = (a: Expr, b: Expr) => a.value - b.value
      val prod = (a: Expr, b: Expr) => a.value * b.value
      val div = (a: Expr, b: Expr) => a.value / b.value
      val mod = (a: Expr, b: Expr) => a.value % b.value
      val intPow = (a: Expr, b: Expr) => math.pow(a.value, b.value).toInt
    }

    object Comparisons {
      val == = (a: Expr, b: Expr) => a.value == b.value
      val != = (a: Expr, b: Expr) => a.value != b.value
      val > = (a: Expr, b: Expr) => a.value > b.value
      val < = (a: Expr, b: Expr) => a.value < b.value
      val >= = (a: Expr, b: Expr) => a.value >= b.value
      val <= = (a: Expr, b: Expr) => a.value <= b.value
    }
  }
}