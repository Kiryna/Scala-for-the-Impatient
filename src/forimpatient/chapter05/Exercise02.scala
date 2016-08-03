package forimpatient.chapter05

/**
  * Created by Iryna Kharaborkina on 8/1/16. 
  *
  * Solution to the Chapter 05 Exercise 02 'Scala for the Impatient' by Horstmann C.S.
  *
  * Write a class BankAccount with methods deposit and withdraw, and a read-only property balance.
  */
object Exercise02 extends App {
  println("Chapter 05 Exercise 02")

  val account = new BankAccount(100)
  println(account.balance)

  account.deposit(20)
  println(account.balance)

  account.withdraw(10)
  println(account.balance)

  class BankAccount(private var b: Double) {
    def deposit(amount: Double): Unit = {
      b += amount
    }

    def withdraw(amount: Double): Unit = {
      b -= amount
    }

    def balance = b
  }
}
