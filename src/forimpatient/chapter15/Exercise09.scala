package forimpatient.chapter15

/**
  * Created by Iryna Kharaborkina on 8/13/16. 
  *
  * Solution to the Chapter 15 Exercise 09 'Scala for the Impatient' by Horstmann C.S.
  *
  * The Range.foreach method is annotated as @specialized(Unit). Why? Look at the bytecode by running
  *     javap -classpath /path/to/scala/lib/scala-library.jar scala.collection.immutable.Range
  * and consider the @specialized annotations on Function1. Click on the Function1.scala link in Scaladoc to see them
  */
object Exercise09 extends App {
  println("Chapter 15 Exercise 09")

  /*
  public class scala.collection.immutable.Range extends scala.collection.AbstractSeq<java.lang.Object> implements
      scala.collection.immutable.IndexedSeq<java.lang.Object>, scala.collection.CustomParallelizable<java.lang.Object,
      scala.collection.parallel.immutable.ParRange>, scala.Serializable {
    ...
    public final <U> void foreach(scala.Function1<java.lang.Object, U>);
    public final void foreach$mVc$sp(scala.Function1<java.lang.Object, scala.runtime.BoxedUnit>);
    ...
  }
  */
}
