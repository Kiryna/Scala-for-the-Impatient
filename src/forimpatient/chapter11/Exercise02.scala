package forimpatient.chapter11

/**
  * Created by Iryna Kharaborkina on 8/8/16. 
  *
  * Solution to the Chapter 11 Exercise 02 'Scala for the Impatient' by Horstmann C.S.
  *
  * The BigInt class has a pow method, not an operator. Why didn’t the Scala library
  * designers choose ** (as in Fortran) or `^` (as in Pascal) for a power operator?
  */
object Exercise02 extends App {
  println("Chapter 11 Exercise 02")

  // This is because of precedence rules, there can be following errors:
  val a = new IntWithPower(2)
  val b = new IntWithPower(4)

  println(a * b ** 2)
  println(a * b ^ 2)

  // while via math rules should be
  println(a * (b ^ 2))


  class IntWithPower(val value: Int) {
    def **(exp: Int) = new IntWithPower(math.pow(value, exp).toInt)
    def ^(exp: Int) = new IntWithPower(math.pow(value, exp).toInt)
    def *(other: IntWithPower) = new IntWithPower(value * other.value)

    override def toString: String = value.toString
  }
}
