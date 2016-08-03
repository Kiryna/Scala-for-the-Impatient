package forimpatient.chapter05

import scala.beans.BeanProperty

/**
  * Created by Iryna Kharaborkina on 8/3/16. 
  *
  * Solution to the Chapter 05 Exercise 05 'Scala for the Impatient' by Horstmann C.S.
  *
  * Make a class Student with read-write JavaBeans properties name (of type String) and id (of type Long).
  * What methods are generated? (Use javap to check.) Can you call the JavaBeans getters and setters in Scala?
  * Should you?
  */
object Exercise05 extends App {
  println("Chapter 05 Exercise 05")
  val a = new Student("Amy", 1)
  println(a.id)
  println(a.name)


  class Student(@BeanProperty var name: String, @BeanProperty var id: Long)

  /*
  public class forimpatient.chapter05.Exercise05$Student {
    public java.lang.String name();
    public void name_$eq(java.lang.String);
    public void setName(java.lang.String);
    public long id();
    public void id_$eq(long);
    public void setId(long);
    public java.lang.String getName();
    public long getId();
    public forimpatient.chapter05.Exercise05$Student(java.lang.String, long);
  }
  */
}
