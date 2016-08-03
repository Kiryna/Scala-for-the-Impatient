package forimpatient.chapter06

/**
  * Created by Iryna Kharaborkina on 8/3/16. 
  *
  * Solution to the Chapter 06 Exercise 07 'Scala for the Impatient' by Horstmann C.S.
  *
  * Implement a function that checks whether a card suit value from the preceding exercise is red.
  */
object Exercise07 extends App {
  println("Chapter 06 Exercise 07")

  for (suit <- Cards.values) println(suit + " is read: " + Cards.isRead(suit))

  object Cards extends Enumeration {
    type Suit = Value
    val Spades = Value("♠")
    val Hearts = Value("♥")
    val Diamonds  = Value("♦")
    val Clubs = Value("♣")

    def isRead(suit: Cards.Suit) = suit == Cards.Diamonds || suit == Cards.Hearts
  }
}
