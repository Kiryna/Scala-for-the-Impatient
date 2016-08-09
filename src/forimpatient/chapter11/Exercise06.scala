package forimpatient.chapter11

/**
  * Created by Iryna Kharaborkina on 8/9/16. 
  *
  * Solution to the Chapter 11 Exercise 06 'Scala for the Impatient' by Horstmann C.S.
  *
  * Provide a class ASCIIArt whose objects contain figures such as
  *     /\_/\
  *    ( ' ' )
  *    (  -  )
  *     | | |
  *    (__|__)
  * Supply operators for combining two ASCIIArt figures horizontally
  *     /\_/\     -----
  *    ( ' ' )  / Hello \
  *    (  -  ) <  Scala |
  *     | | |   \ Coder /
  *    (__|__)    -----
  *
  *    or vertically. Choose operators with appropriate precedence.
  */
object Exercise06 extends App {
  println("Chapter 11 Exercise 06")

  val a = ASCIIArt(
    """|  /\_/\
       | ( ' ' )
       | (  -  )
       |  | | |
       | (__|__)
       |""".stripMargin)

  val b = ASCIIArt(
    """|   -----
       | / Hello \
       |<  Scala |
       | \ Coder /
       |   -----
       |""".stripMargin
  )

  val c = new ASCIIArt("      ")

  println(a + b + c + a + a)

  class ASCIIArt(val art: String) {

    def ^(other: ASCIIArt) = new ASCIIArt(art + other.art)

    def +(other: ASCIIArt) = {
      val artLines: Array[String] = art.split("\n")
      val otherArtLines: Array[String] = other.art.split("\n")
      val width = artLines.maxBy(_.length).length + 1
      val newArt = artLines.zipAll(otherArtLines, "", "").map(x => x._1 + " " * (width - x._1.length) + x._2)
      new ASCIIArt(newArt.mkString("\n"))
    }

    override def toString = art
  }

  object ASCIIArt {
    def apply(art: String) = new ASCIIArt(art)
  }
}
