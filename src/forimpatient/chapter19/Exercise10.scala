package forimpatient.chapter19

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer
import scala.io.Source
import scala.util.parsing.combinator.syntactical.StandardTokenParsers

/**
  * Created by Iryna Kharaborkina on 9/5/16. 
  *
  * Solution to the Chapter 19 Exercise 10 'Scala for the Impatient' by Horstmann C.S.
  *
  * Add function definitions to the programming language of the preceding exercise.
  */
object Exercise10 extends App {
  println("Chapter 19 Exercise 10")

  val parser = new ExprParser
  val program = Source.fromFile("src/forimpatient/chapter19/program_03.mylng").mkString
  val result = parser.parseAll(parser.program, program)

  class ExprParser extends StandardTokenParsers {
    import Arithmetic._

    lexical.delimiters += ("+", "-", "*", "(", ")", ";", "%", "/", "^", "=", "==", "!=", ">=", "<=", ">", "<", "{", "}")
    lexical.reserved += ("if", "else", "while", "def", "return")

    val number = numericLit
    val varName = ident
    val variables = mutable.Stack[mutable.Map[String, Int]](mutable.Map[String, Int]())
    val functions = mutable.Map[String, Function]()

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

    def factor: Parser[Expr] = number ^^ (n => Number(n.toInt)) | "(" ~> expr <~ ")" | function | variable

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

    def repeatedStatements: Parser[List[Statement]] = (opt("{") ~>rep(control | assignment | defFunction | functionReturn) <~ opt("}")) ^^ {
      r => {val statements = ArrayBuffer[Statement](); for (s <- r) s match {
        case f: Function => ()
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

    def defFunction: Parser[Function] = "def" ~> ident ~ ("(" ~> rep(ident) <~ ")" <~ opt("=")) ~ (opt("{")
      ~> repeatedStatements <~ opt("}")) ^^ {
      case funName ~ parms ~ body => {functions(funName) = Function(funName, parms, body); functions(funName)}
    }

    def function: Parser[FunctionCall] = ident ~ ("(" ~> rep(expr) <~ ")") ^^ {
      case funName ~ params => FunctionCall(funName, params)
    }

    def functionReturn: Parser[Return] = "return" ~> expr <~ opt(";") ^^ {e => Return(e)}

    abstract class Statement {
      def execute(): Option[Int]
    }

    case class Assignment(varName: String, varValue: Expr) extends Statement {
      def execute(): Option[Int] = {
        val v = varValue.value
        varName match {
          case "out" => println(v)
          case _ => variables.head(varName) = v
        }
        None
      }
    }

    case class Control(bool: Bool, op: String, left: List[Statement], right: Option[List[Statement]] = None) extends Statement {
      def execute(): Option[Int] = {op match {
        case "if" => if (bool.bool) left.map(_.execute()).last else if (right.isDefined) right.get.map(_.execute()).last else None
        case "while" => while (bool.bool) left.foreach(_.execute()); None
      }}
    }

    case class Return(expr: Expr) extends Statement{
      override def execute(): Option[Int] = Some(expr.value)
    }

    case class Function(name: String, parms: List[String], op: List[Statement], parmValues: List[Expr] = null) extends Statement {
      def execute(): Option[Int] = {
        val pv: List[(String, Int)] = parms.zip(parmValues.map(_.value))
        val vars = variables.head
        variables.push(vars ++ pv)

        val rtrn: Option[Int] = op.map(_.execute()).last
        variables.pop()
        rtrn
      }

      def instance(values: List[Expr]) = {
        FunctionCall(name, values)
      }
    }

    case class FunctionCall(name: String, values: List[Expr]) extends Expr {
      override def value = {
        val foo = functions(name)
        val currentFoo = Function(name, foo.parms, foo.op, values)
        currentFoo.execute() match {
          case Some(n) => n
          case None => 0
        }
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
      override def value: Int = variables.head.getOrElse(name, 0)
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
