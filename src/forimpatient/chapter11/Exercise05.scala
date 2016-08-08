package forimpatient.chapter11

import java.io.PrintWriter

import scala.collection.mutable.ArrayBuffer

/**
  * Created by Iryna Kharaborkina on 8/8/16. 
  *
  * Solution to the Chapter 11 Exercise 05 'Scala for the Impatient' by Horstmann C.S.
  *
  * Provide operators that construct an HTML table. For example,
  *       Table() | "Java" | "Scala" || "Gosling" | "Odersky" || "JVM" | "JVM, .NET"
  * should produce
  *      `<table><tr><td>Java</td><td>Scala</td></tr><tr><td>Gosling...`
  */
object Exercise05 extends App {
  println("Chapter 11 Exercise 05")

  private val out: PrintWriter = new PrintWriter("src/forimpatient/chapter11/table.html")
  private val table: Table = Table() | "Java" | "Scala" || "Gosling" | "Odersky" || "JVM" | "JVM, .NET"
  println(table)
  out.print(table)
  out.close()

  class Table {
    private val cells = ArrayBuffer("<table>")

    def |(str: String) = {
      if (cells.size == 1) cells += "<tr>"
      cells += "<td>" + str + "</td>"
      this
    }

    def ||(str: String) = {
      cells += "</tr><tr>"
      cells += "<td>" + str + "</td>"
      this
    }

    override def toString = {
      val postfix = if (cells.size > 1) "</tr></table>" else "</table>"
      cells.mkString("") + postfix
    }
  }

  object Table {
    def apply() = new Table
  }
}
