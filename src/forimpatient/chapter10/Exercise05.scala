package forimpatient.chapter10

import java.awt.Point
import java.beans.{PropertyChangeEvent, PropertyChangeListener}

/**
  * Created by Iryna Kharaborkina on 8/8/16. 
  *
  * Solution to the Chapter 10 Exercise 05 'Scala for the Impatient' by Horstmann C.S.
  *
  * The JavaBeans specification has the notion of a property change listener, a standardized way for beans
  * to communicate changes in their properties. The PropertyChangeSupport class is provided
  * as a convenience superclass for any bean that wishes to support property change listeners.
  * Unfortunately, a class that already has another superclass—such as JComponent—must reimplement the methods.
  * Reimplement PropertyChangeSupport as a trait, and mix it into the java.awt.Point class.
  */
object Exercise05 extends App {
  println("Chapter 10 Exercise 05")

  val point = new Point with PropertyChangeSupport {
    override def move(x: Int, y: Int): Unit = {
      val oldX = getX
      val oldY = getY
      super.move(x, y)
      pcs.firePropertyChange("x", oldX, getX)
      pcs.firePropertyChange("y", oldY, getY)
    }
  }

  private val listener: PointChangeListener = new PointChangeListener
  point.addPropertyChangeListener(listener)
  point.move(2, 4)

  point.removePropertyChangeListener(listener)
  point.move(1, 3)

  class PointChangeListener extends PropertyChangeListener {
    override def propertyChange(evt: PropertyChangeEvent): Unit =
      println(evt.getPropertyName + ": " + evt.getOldValue + " to " + evt.getNewValue)
  }

  trait PropertyChangeSupport {
    val pcs = new java.beans.PropertyChangeSupport

    def addPropertyChangeListener(listener: PropertyChangeListener): Unit = pcs.addPropertyChangeListener(listener)
    def removePropertyChangeListener(listener: PropertyChangeListener): Unit = pcs.removePropertyChangeListener(listener)
  }
}
