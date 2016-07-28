package forimpatient.chapter03

import java.util.TimeZone.getAvailableIDs

/**
  * Created by Iryna Kharaborkina on 7/28/16.
  *
  * Solution to the Chapter 03 Exercise 09 'Scala for the Impatient' by Horstmann C.S.
  *
  * Make a collection of all time zones returned by java.util.TimeZone.getAvailableIDs that are in America.
  * Strip off the "America/" prefix and sort the result.
  */
object Exercise09 extends App {
  println("Chapter 03 Exercise 09")

  private val prefix: String = "America/"
  getAvailableIDs().filter(_.startsWith(prefix)).map(zone => zone.stripPrefix(prefix)).sorted.foreach(println(_))
}
