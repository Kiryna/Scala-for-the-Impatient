package forimpatient.chapter06

/**
  * Created by Iryna Kharaborkina on 8/3/16. 
  *
  * Solution to the Chapter 06 Exercise 06 'Scala for the Impatient' by Horstmann C.S.
  *
  * Write an enumeration describing the four playing card suits so that the toString method returns ♣, ♦, ♥, or ♠.
  */
object Exercise06 extends App {
  println("Chapter 06 Exercise 06")

  println(Cards.Clubs.toString)
  println(Cards.Diamonds.toString)
  println(Cards.Spades.toString)
  println(Cards.Hearts.toString)

  object Cards extends Enumeration {
    type Suit = Value
    val Spades = Value("♠")
    val Hearts = Value("♥")
    val Diamonds  = Value("♦")
    val Clubs = Value("♣")
  }
}
