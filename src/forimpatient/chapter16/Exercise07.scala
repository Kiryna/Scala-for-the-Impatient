package forimpatient.chapter16

/**
  * Created by Iryna Kharaborkina on 8/23/16. 
  *
  * Solution to the Chapter 16 Exercise 07 'Scala for the Impatient' by Horstmann C.S.
  *
  * Write a function that has a parameter of type Map[String, String] and returns a dl element with a dt for each key
  * and dd for each value. For example, Map("A" -> "1", "B" -> "2") should yield
  * <dl><dt>A</dt><dd>1</dd><dt>B</dt><dd>2</dd></dl>.
  */
object Exercise07 extends App {
  println("Chapter 16 Exercise 07")

  def createList(map: Map[String, String]) = <dl>{for ((k, v) <- map) yield <dt>{k}</dt><dd>{v}</dd>}</dl>

  println(createList(Map("A" -> "1", "B" -> "2")))

}
