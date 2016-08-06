package forimpatient.chapter08

/**
  * Created by Iryna Kharaborkina on 8/6/16. 
  *
  * Solution to the Chapter 08 Exercise 08 'Scala for the Impatient' by Horstmann C.S.
  *
  * Compile the Person and SecretAgent classes in Section 8.6, “Overriding Fields,” on page 89
  * and analyze the class files with javap. How many name fields are there? How many name getter
  * methods are there? What do they get? (Hint: Use the -c and -private options.)
  */
object Exercise08 extends App {
  println("Chapter 08 Exercise 08")

  class Person(val name: String) {
    override def toString() = getClass.getName + "[name=" + name + "]"
  }

  /*
    public class forimpatient.chapter08.Exercise08$Person {
      private final java.lang.String name;
      public java.lang.String name();
      public java.lang.String toString();
      public forimpatient.chapter08.Exercise08$Person(java.lang.String);
    }
   */

  class SecretAgent(codename: String) extends Person(codename) {
    override val name = "secret"
    override val toString = "secret"
  }

  /*
    public class forimpatient.chapter08.Exercise08$SecretAgent extends forimpatient.chapter08.Exercise08$Person {
      private final java.lang.String name;
      private final java.lang.String toString;
      public java.lang.String name();
      public java.lang.String toString();
      public forimpatient.chapter08.Exercise08$SecretAgent(java.lang.String);
    }
  */
}
