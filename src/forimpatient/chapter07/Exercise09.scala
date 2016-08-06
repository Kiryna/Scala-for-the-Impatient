package forimpatient.chapter07

/**
  * Created by Iryna Kharaborkina on 8/6/16. 
  *
  * Solution to the Chapter 07 Exercise 09 'Scala for the Impatient' by Horstmann C.S.
  *
  * Write a program that imports the java.lang.System class, reads the user name from the user.name system property,
  * reads a password from the Console object, and prints a message to the standard error stream
  * if the password is not "secret". Otherwise, print a greeting to the standard output stream.
  * Do not use any other imports, and do not use any qualified names (with dots).
  */
object Exercise09 extends App {
  println("Chapter 07 Exercise 09")

  login()

  def login(): Unit = {
    import System._
    import Console.{in, err, out}

    val userName = getProperty("user.name")
    out.print("Username: " + userName + "; password: ")
    val password = in.readLine()
    if (password equals "secret") out.println("Greeting, " + userName + "!. You are logged in")
    else err.println("Incorrect password!")
  }
}
