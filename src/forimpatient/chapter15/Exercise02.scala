package forimpatient.chapter15

import com.sun.istack.internal.NotNull

/**
  * Created by Iryna Kharaborkina on 8/12/16. 
  *
  * Solution to the Chapter 15 Exercise 02 'Scala for the Impatient' by Horstmann C.S.
  *
  * Make an example class that shows every possible position of an annotation.
  * Use @deprecated as your sample annotation.
  */
object Exercise02 extends App {
  println("Chapter 15 Exercise 02")

  val old = new OldExercise
  println(old.toString)

  @deprecated class OldExercise(@deprecated @NotNull unused:Int = 0) {
    @deprecated val str = "I am deprecated!"

    @deprecated override def toString: String = {
      @deprecated val end = " This is the end!"
      str + end
    }
  }
}
