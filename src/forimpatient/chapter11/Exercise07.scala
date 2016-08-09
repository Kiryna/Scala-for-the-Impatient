package forimpatient.chapter11

/**
  * Created by Iryna Kharaborkina on 8/9/16. 
  *
  * Solution to the Chapter 11 Exercise 07 'Scala for the Impatient' by Horstmann C.S.
  *
  * Implement a class BitSequence that stores a sequence of 64 bits packed in a Long value.
  * Supply apply and update operators to get and set an individual bit.
  */
object Exercise07 extends App {
  println("Chapter 11 Exercise 07")

  val a = BitSequence(31, 62)
  println(a.seq)
  println(math.pow(2, 62) + math.pow(2, 31))
  println(a(31))
  println(a(62))
  println(a(0))

  a(0) = 1
  println(a(0))
  a(31) = 0
  println(a(31))

  class BitSequence() {
    var seq: Long = 0
    def apply(n: Int) = (seq & 1L << n) >> n

    def update(n: Int, value: Int) = if (value == 0) seq &= ~ 1L << n else seq |= 1L << n
  }

  object BitSequence {
    def apply(seq: Int*) = {
      var container = 0L
      for (b <- seq) container = container | 1L << b
      val bitSeq = new BitSequence()
      bitSeq.seq = container
      bitSeq
    }
  }
}
