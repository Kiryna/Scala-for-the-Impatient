package forimpatient.chapter08

/**
  * Created by Iryna Kharaborkina on 8/6/16. 
  *
  * Solution to the Chapter 08 Exercise 02 'Scala for the Impatient' by Horstmann C.S.
  *
  * Extend the BankAccount class of the preceding exercise into a class SavingsAccount that earns interest every month
  * (when a method earnMonthlyInterest is called) and has three free deposits or withdrawals every month.
  * Reset the transaction count in the earnMonthlyInterest method.
  */
object Exercise02 extends App {
  println("Chapter 08 Exercise 02")

  println("Chapter 08 Exercise 01")

  val acc = new SavingAccount(10)
  println(acc.currentBalance)
  acc.deposit(2)
  println(acc.currentBalance)
  acc.withdraw(1)
  println(acc.currentBalance)
  acc.withdraw(1)
  println(acc.currentBalance)
  acc.deposit(10)
  println(acc.currentBalance)
  acc.earnMonthlyInterest(0.01)
  println(acc.currentBalance)

  class SavingAccount(initialBalance: Double) extends BankAccount(initialBalance) {
    private val freeCount = 3
    private var monthCount = 0
    private val charge = 1

    def earnMonthlyInterest(percents: Double): Unit = {super.deposit(currentBalance * percents)}
    override def deposit(amount: Double) = {monthCount += 1; super.deposit(amount - (if (monthCount < freeCount) 0 else charge))}
    override def withdraw(amount: Double) = {monthCount += 1; super.withdraw(amount + (if (monthCount < freeCount) 0 else charge))}
  }

  class BankAccount(initialBalance: Double) {
    private var balance = initialBalance
    def currentBalance = balance
    def deposit(amount: Double) = { balance += amount; balance }
    def withdraw(amount: Double) = { balance -= amount; balance }
  }
}
