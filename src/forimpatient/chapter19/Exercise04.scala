package forimpatient.chapter19

import java.util.{Date, GregorianCalendar}

import scala.util.parsing.combinator.RegexParsers

/**
  * Created by Iryna Kharaborkina on 9/3/16. 
  *
  * Solution to the Chapter 19 Exercise 04 'Scala for the Impatient' by Horstmann C.S.
  *
  * Write a parser that can parse date and time expressions in ISO 8601. Your parser should return a java.util.Date object
  *
  * Supports combinations of the following date formats:
  *     YYYY-MM-DD
  *     YYYYMMDD
  *     YYYY-MM
  *     --MM-DD
  *
  * and time formats:
  *     hh:mm:ss
  *     hhmmss
  *     hh:mm
  *     hhmm
  *     hh
  */
object Exercise04 extends App {
  println("Chapter 19 Exercise 04")

  val dates = Array(
    "2016-09-27 13:27:55",
    "2016-09-27 13:27",

    "2016-09-27 132755",
    "2016-09-27 1327",
    "2016-09-27 13",

    "2016-09-27",
    "20160927",
    "2016-09",
    "--09-27"
  )

  val parser = new DateParser
  for (d <- dates) {
    val result = parser.parseAll(parser.parseDate, d)
    if (result.successful) println(result.get)
  }

  class DateParser extends RegexParsers {
    val eightDigits = """\d{8}""".r
    val sixDigits = """\d{6}""".r
    val fourDigits = """\d{4}""".r
    val twoDigits = """\d{2}""".r

    def parseDate: Parser[Date] = (date ~ opt(time)) ^^ {
      case y ~ Some(t) => new GregorianCalendar(y._1, y._2, y._3, t._1, t._2, t._3).getTime
      case y ~ None => new GregorianCalendar(y._1, y._2, y._3).getTime
    }

    def date: Parser[(Int, Int, Int)] = yyyy ~ ("-" ~> dd) ~ opt("-" ~> dd) ^^ {
      case year ~ month ~ Some(date) => (year, month - 1, date)
      case year ~ month ~ None => (year, month - 1, 1)
    } | "--" ~> dd ~ ("-" ~> dd) ^^ {
      case month ~ date => (1900, month - 1, date)
    } | yyyymmdd

    def time: Parser[(Int, Int, Int)] = hhmmss | hhmm | dd ~ rep(":" ~> dd) ^^ {
      case h ~ List(m, s)  => (h, m, s)
      case h ~ List(m)  => (h, m, 0)
      case h ~ _  => (h, 0, 0)
    }

    def dd: Parser[Int] =  twoDigits ^^ (_.toInt)

    def yyyy: Parser[Int] =  fourDigits ^^ (_.toInt)

    def hhmm: Parser[(Int, Int, Int)] =  fourDigits ^^ {
      t => (t.substring(0, 2).toInt, t.substring(2, 4).toInt, 0)
    }

    def hhmmss: Parser[(Int, Int, Int)] =  sixDigits ^^ {
      t => (t.substring(0, 2).toInt, t.substring(2, 4).toInt, t.substring(4, 6).toInt)
    }

    def yyyymmdd: Parser[(Int, Int, Int)] =  eightDigits ^^ {
      y => (y.substring(0, 4).toInt, y.substring(4, 6).toInt - 1, y.substring(6, 8).toInt)
    }
  }
}
