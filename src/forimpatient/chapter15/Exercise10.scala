package forimpatient.chapter15

import scala.annotation.elidable
import scala.annotation.elidable.FINE
import scala.annotation.meta.beanGetter
import scala.beans.BeanProperty

/**
  * Created by Iryna Kharaborkina on 8/13/16. 
  *
  * Solution to the Chapter 15 Exercise 10 'Scala for the Impatient' by Horstmann C.S.
  *
  * Add assert(n >= 0) to a factorial method. Compile with assertions enabled and verify that factorial(-1) throws
  * an exception. Compile without assertions. What happens? Use javap to check what happened to the assertion call.
  */
object Exercise10 extends App {
  println("Chapter 15 Exercise 10")

  println(factorial(3))
  println(factorial(0))
  println(factorial(-2))

  @elidable(FINE) def factorial(n: Int): Int = {
    assert(n >= 0)
    (1 to n).product
  }

  /* -Xelide-below WARNING
  public static int factorial(int);
    Code:
       0: getstatic     #16
  */

  /* -Xelide-below ALL
  public static int factorial(int);
    Code:
       0: getstatic     #16                 // Field forimpatient/chapter15/Exercise10$.MODULE$:Lforimpatient/chapter15/Exercise10$;
       3: iload_0
       4: invokevirtual #42                 // Method forimpatient/chapter15/Exercise10$.factorial:(I)I
       7: ireturn
  */
}
