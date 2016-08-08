package forimpatient.chapter10

/**
  * Created by Iryna Kharaborkina on 8/8/16. 
  *
  * Solution to the Chapter 10 Exercise 04 'Scala for the Impatient' by Horstmann C.S.
  *
  * Provide a CryptoLogger trait that encrypts the log messages with the Caesar cipher.
  * The key should be 3 by default, but it should be overridable by the user.
  * Provide usage examples with the default key and a key of –3.
  */
object Exercise04 extends App {
  println("Chapter 10 Exercise 04")

  val demoA = new Demo with CryptoLogger
  val demoB = new Demo with CryptoLogger {override val key = 8}
  val demoC = new Demo

  demoA.log("Super secure message")
  demoB.log("Super secure message")
  demoC.log("Just a message")


  class Demo extends Logger {
    override def log(msg: String): Unit = println(msg)
  }

  trait CryptoLogger extends Logger {
    val key = 3
    private val length: Int = 26

    private def encodeCesar(ch: Char) = {
      if ('A' > ch || ch >'Z') ch
      else ((ch.toInt - 'A' + key) % length + 'A').toChar
    }

    private def decodeCesar(ch: Char) = {
      if ('A' > ch || ch > 'Z') ch
      else ((ch.toInt - 'A' - key + length) % length + 'A').toChar
    }

    abstract override def log(msg: String): Unit = {
      val encodedMsg = for (ch <- msg.toUpperCase) yield encodeCesar(ch)
      val decodedMsg = for (ch <- encodedMsg) yield decodeCesar(ch)
      assert(decodedMsg == msg.toUpperCase())
      super.log(encodedMsg)
    }
  }

  trait Logger {
    def log(msg: String)
    def info(msg: String) {log("INFO: " + msg)}
    def warn(msg: String) {log("WARN: " + msg)}
    def severe(msg: String) {log("SEVERE: " + msg)}
  }
}
