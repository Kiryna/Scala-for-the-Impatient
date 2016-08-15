package forimpatient.chapter15

import scala.annotation.elidable
import scala.annotation.elidable.CONFIG
import scala.annotation.meta.{beanGetter, beanSetter}
import scala.beans.BeanProperty

/**
  * Created by Iryna Kharaborkina on 8/15/16. 
  *
  * Solution to the Chapter 15 Exercise 03 'Scala for the Impatient' by Horstmann C.S.
  */
object Exercise03 extends App {
  println("Chapter 15 Exercise 03")

  val annotated = new BeanAnnotated
  annotated.setB("Hello")
  println(annotated.b)
  println(annotated.getB)
  annotated.setA(3)
  println(annotated.getA)

  class BeanAnnotated {
    @(deprecated @beanSetter)("Use scala setter instead", "1.1") @BeanProperty var a: Int = 0
    @(elidable @beanGetter)(CONFIG) @BeanProperty var b: String = ""
  }
}
