package forimpatient.chapter03

import java.awt.datatransfer.{DataFlavor, SystemFlavorMap}

import scala.collection.mutable
import scala.collection.JavaConversions.asScalaBuffer

/**
  * Created by Iryna Kharaborkina on 7/28/16. 
  *
  * Solution to the Chapter 03 Exercise 10 'Scala for the Impatient' by Horstmann C.S.
  *
  * Import java.awt.datatransfer._ and make an object of type SystemFlavorMap with the call
  *       val flavors = SystemFlavorMap.getDefaultFlavorMap().asInstanceOf[SystemFlavorMap]
  * Then call the getNativesForFlavor method with parameter DataFlavor.imageFlavor and get
  * the return value as a Scala buffer. (Why this obscure class? It’s hard to find uses of
  * java.util.List in the standard Java library.)
  */
object Exercise10 extends App {
  println("Chapter 03 Exercise 10")

  val flavors = SystemFlavorMap.getDefaultFlavorMap().asInstanceOf[SystemFlavorMap]
  val imageFlavors: mutable.Buffer[String] = flavors.getNativesForFlavor(DataFlavor.imageFlavor)
  println(imageFlavors)
}
