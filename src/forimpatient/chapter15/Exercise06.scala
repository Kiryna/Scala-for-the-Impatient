package forimpatient.chapter15

/**
  * Created by Iryna Kharaborkina on 8/13/16. 
  *
  * Solution to the Chapter 15 Exercise 06 'Scala for the Impatient' by Horstmann C.S.
  *
  * Write a Scala object with a volatile Boolean field. Have one thread sleep for some time, then set the field to true,
  * print a message, and exit. Another thread will keep checking whether the field is true. If so, it prints a message
  * and exits. If not, it sleeps for a short time and tries again.
  * What happens if the variable is not volatile?
  */
object Exercise06 extends App {
  println("Chapter 15 Exercise 06")

  @volatile var bool = false

  new Thread(new Runnable {
    override def run(): Unit = {
      Thread.sleep(1000)
      bool = true
    }
  }).start()

  new Thread(new Runnable {
    override def run(): Unit = {
      while (!bool) Thread.sleep(10)
      println("Variable is true!")
    }
  }).start()
}
