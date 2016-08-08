package forimpatient.chapter10

/**
  * Created by Iryna Kharaborkina on 8/8/16. 
  *
  * Solution to the Chapter 10 Exercise 06 'Scala for the Impatient' by Horstmann C.S.
  *
  * In the Java AWT library, we have a class Container, a subclass of Component that collects multiple components.
  * For example, a Button is a Component, but a Panel is a Container. That’s the composite pattern at work.
  * Swing has JComponent and JContainer, but if you look closely, you will notice something strange.
  * JComponent extends Container, even though it makes no sense to add other components to, say, a JButton.
  * The Swing designers would have ideally preferred the design in But that’s not possible in Java.
  * Explain why not. How could the design be executed in Scala with traits?
  */
object Exercise06 extends App {
  println("Chapter 10 Exercise 06")

  val button = new JButton
  println(button)

  val panel = new JPanel
  println(panel)

  trait Component {
    override def toString: String = "Component"
  }
  trait JComponent extends Component {
    override def toString: String = super.toString + " | JComponent"
  }
  trait Container extends Component {
    override def toString: String = super.toString + " | Container"
  }

  class JContainer extends Container with JComponent  {
    override def toString: String = super.toString  + " | JContainer"
  }

  class JButton extends JComponent  {
    override def toString = super.toString  + " | JButton"
  }

  class JPanel extends JContainer {
    override def toString = super.toString  + " | JPanel"
  }
}
