package forimpatient.chapter15

import forimpatient.chapter06.Exercise02.{GallonsToLiters, InchesToCentimeters, MilesToKilometers}
import org.scalatest.junit.AssertionsForJUnit
import org.junit.Assert.{assertEquals, assertNotNull}
import org.junit.Test

/**
  * Created by Iryna Kharaborkina on 8/12/16. 
  *
  * Solution to the Chapter 15 Exercise 01 'Scala for the Impatient' by Horstmann C.S.
  *
  * Write four JUnit test cases that use the @Test annotation with and without each of its arguments.
  * Run the tests with JUnit.
  */
class Exercise01 extends AssertionsForJUnit {
  val delta = 0.00001

  @Test def testNotNull() = {
    val actual = "10"
    assertNotNull(actual)
  }

  @Test def testInchesToCentimeters() = {
    val actual = InchesToCentimeters.convert(10)
    val expected = 25.4
    assertEquals(expected, actual, delta)
  }

  @Test def testGallonsToLiters() = {
    val actual = GallonsToLiters.convert(10)
    val expected = 37.8541178
    assertEquals(expected, actual, delta)
  }

  @Test def testMilesToKilometers() = {
    val actual = MilesToKilometers.convert(10)
    val expected = 16.09344
    assertEquals(expected, actual, delta)
  }
}
