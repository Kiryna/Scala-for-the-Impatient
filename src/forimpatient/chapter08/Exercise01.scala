package forimpatient.chapter08

/**
  * Created by Iryna Kharaborkina on 8/6/16. 
  *
  * Solution to the Chapter 08 Exercise 01 'Scala for the Impatient' by Horstmann C.S.
  *
  * Extend the following BankAccount class to a CheckingAccount class that charges $1 for every deposit and withdrawal.
  */
object Exercise01 extends App {
  println("Chapter 08 Exercise 01")

  val acc = new CheckingAccount(10)
  println(acc.currentBalance)
  acc.deposit(2)
  println(acc.currentBalance)
  acc.withdraw(1)
  println(acc.currentBalance)

  class CheckingAccount(initialBalance: Double) extends BankAccount(initialBalance) {
    val charge = 1
    override def deposit(amount: Double) = super.deposit(amount - charge)
    override def withdraw(amount: Double) = super.withdraw(amount + charge)
  }

  class BankAccount(initialBalance: Double) {
    private var balance = initialBalance
    def currentBalance = balance
    def deposit(amount: Double) = { balance += amount; balance }
    def withdraw(amount: Double) = { balance -= amount; balance }
  }
}
