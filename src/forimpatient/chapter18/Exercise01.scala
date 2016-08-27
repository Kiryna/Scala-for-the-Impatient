package forimpatient.chapter18

/**
  * Created by Iryna Kharaborkina on 8/27/16. 
  *
  * Solution to the Chapter 18 Exercise 01 'Scala for the Impatient' by Horstmann C.S.
  *
  * Implement a Bug class modeling a bug that moves along a horizontal line. The move method moves
  * in the current direction, the turn method makes the bug turn around, and the show method prints
  * the current position. Make these methods chainable. For example,
  */
object Exercise01 extends App {
  println("Chapter 18 Exercise 01")
  val bugsy = new Bug
  bugsy.move(4).show().move(6).show().turn().move(5).show()

  class Bug {
    private var position = 0
    private var direction = 1
    def move(dim: Int): this.type = {position += direction * dim; this}
    def turn(): this.type = {direction = - direction; this}
    def show(): this.type = {print(position + " "); this}
  }

}
