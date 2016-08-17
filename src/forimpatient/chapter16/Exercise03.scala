package forimpatient.chapter16

import scala.xml.Text

/**
  * Created by Iryna Kharaborkina on 8/17/16. 
  *
  * Solution to the Chapter 16 Exercise 03 'Scala for the Impatient' by Horstmann C.S.
  *
  * Contrast
  *     <li>Fred</li> match { case <li>{Text(t)}</li> => t }
  * and
  *     <li>{"Fred"}</li> match { case <li>{Text(t)}</li> => t }
  * Why do they act differently?
  */
object Exercise03 extends App {
  println("Chapter 16 Exercise 03")

  val a = <li>Fred</li> match { case <li>{Text(t)}</li> => t }
  val b = <li>{"Fred"}</li> match { case <li>{t}</li> => t }

  println(a)
  println(b)
}
