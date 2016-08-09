package forimpatient.chapter11

/**
  * Created by Iryna Kharaborkina on 8/9/16. 
  *
  * Solution to the Chapter 11 Exercise 08 'Scala for the Impatient' by Horstmann C.S.
  *
  * Provide a class Matrix—you can choose whether you want to implement 2 × 2 matrices, square matrices of any size,
  * or m × n matrices. Supply operations + and *. The latter should also work with scalars, for example mat * 2.
  * A single element should be accessible as mat(row, col).
  */
object Exercise08 extends App {
  println("Chapter 11 Exercise 08")

  val m = new Matrix(2, 2, 1)
  m(0, 1) = 10
  m(1, 0) = 5
  println(m)
  val n = new Matrix(2, 2, 2)
  n(0, 0) = 3
  n(1, 0) = 5
  n(1, 1) = 3

  println(n)
  println(m * n)
  println(n * m)
  println(n * 3)

  println(n(0, 0))

  class Matrix(val m: Int, val n: Int, default: Int = 0) {
    val matrix: Array[Array[Double]] = new Array[Array[Double]](m)
    for (i <- 0 until m) matrix(i) = {
      val row = new Array[Double](n)
      for (j <- 0 until n) row(j) = default
      row
    }

    def apply(i: Int, j: Int) = matrix(i)(j)

    def update(i: Int, j: Int, value: Double) = matrix(i)(j) = value

    def +(other: Matrix) = {
      if (other.m == m && other.n == n) {
        val result = new Matrix(m, n)
        for (i <- 0 until m; j <- 0 until n) result(i, j) = this(i, j) + other(i, j)
        result
      } else ()
    }

    def *(other: Matrix) = {
      if (n == other.m) {
        val result = new Matrix(other.n, m)
        for (i <- 0 until m; j <- 0 until other.n; k <- 0 until n) result(i, j) += this(i, k) * other(k, j)
        result
      }
      else ()
    }

    def *(num: Double) = {
      val result = new Matrix(m, n)
      for (i <- 0 until m; j <- 0 until n) result(i, j) = this(i, j) * num
      result
    }

    override def toString = matrix.map(_.mkString("[", " ", "]")).mkString("[", "\n ", "]")
  }
}
