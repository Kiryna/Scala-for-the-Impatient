package forimpatient.chapter16

/**
  * Created by Iryna Kharaborkina on 8/17/16. 
  *
  * Solution to the Chapter 16 Exercise 02 'Scala for the Impatient' by Horstmann C.S.
  *
  * What is the result of
  *     <ul>
  *       <li>Opening bracket: [</li>
  *       <li>Closing bracket: ]</li>
  *       <li>Opening brace: {</li>
  *       <li>Closing brace: }</li>
  *     </ul>
  * How do you fix it?
  */
object Exercise02 extends App {
  println("Chapter 16 Exercise 02")

  val xml = <ul>
    <li>Opening bracket: [</li>
    <li>Closing bracket: ]</li>
    <li>Opening brace: {{</li>
    <li>Closing brace: }}</li>
    </ul>
  println(xml)
}
