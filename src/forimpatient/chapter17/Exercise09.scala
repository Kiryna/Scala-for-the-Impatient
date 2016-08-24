package forimpatient.chapter17

/**
  * Created by Iryna Kharaborkina on 8/24/16. 
  *
  * Solution to the Chapter 17 Exercise 09 'Scala for the Impatient' by Horstmann C.S.
  *
  * It may seem strange to restrict method parameters in an immutable class Pair[+T]. However, suppose you could define
  *     def replaceFirst(newFirst: T)
  * in a Pair[+T]. The problem is that this method can be overridden in an unsound way.
  *
  * Construct an example of the problem. Define a subclass NastyDoublePair of Pair[Double]
  * that overrides replaceFirst so that it makes a pair with the square root of newFirst.
  * Then construct the call replaceFirst("Hello") on a Pair[Any] that is actually a NastyDoublePair.
  */
object Exercise09 extends App {
  println("Chapter 17 Exercise 09")

  val any: Pair[Any] = new NastyDoublePair(1, 2)
  private val hello: Pair[Any] = any.replaceFirst("Hello") // Error
  private val four: Pair[Any] = any.replaceFirst(4.0)

  println(any)
  println(hello)
  println(four)

  class Pair[+T](val first: T, val second: T) {
    def replaceFirst[R >: T](newFirst: R) = new Pair(newFirst, second)
    override def toString: String = getClass.getSimpleName + "[" + first + " -> " + second + "]"
  }

  class NastyDoublePair(first: Double, second: Double) extends Pair[Double](first, second) {
    override def replaceFirst[R >: Double](newFirst: R) = new NastyDoublePair(math.sqrt(newFirst.asInstanceOf[Double]), second)
  }

}
