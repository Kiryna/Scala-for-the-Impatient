package forimpatient.chapter18

/**
  * Created by Iryna Kharaborkina on 8/27/16. 
  *
  * Solution to the Chapter 18 Exercise 02 'Scala for the Impatient' by Horstmann C.S.
  *
  * Provide a fluent interface for the Bug class of the preceding exercise, so that one can write
  *       bugsy move 4 and show and then move 6 and show turn around move 5 and show
  */
object Exercise02 extends App {
  println("Chapter 18 Exercise 02")

  val bugsy = new Bug
  bugsy move 4 and show and then move 6 and show turn around move 5 and show

  class Bug {
    private var position = 0
    private var direction = 1

    def move(dim: Int): this.type = {position += direction * dim; this}
    def show_(): this.type = {print(position + " "); this}

    def turn(obj: around.type): this.type = {direction = - direction; this}
    def and(obj: show.type): this.type = this.show_()
    def and(obj: then.type):this.type = this
  }

  object show
  object then
  object around
}
