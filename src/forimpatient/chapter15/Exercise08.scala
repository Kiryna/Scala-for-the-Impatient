package forimpatient.chapter15

/**
  * Created by Iryna Kharaborkina on 8/13/16. 
  *
  * Solution to the Chapter 15 Exercise 08 'Scala for the Impatient' by Horstmann C.S.
  *
  * Add the allDifferent method to an object, compile and look at the bytecode.
  * What methods did the @specialized annotation generate?
  */
object Exercise08 extends App {
  println("Chapter 15 Exercise 08")

  def allDifferent[@specialized T](x: T, y: T, z: T) = x != y && x != z && y != z

  /*
  public final class forimpatient.chapter15.Exercise08$ implements scala.App {
      ...
      public <T> boolean allDifferent(T, T, T);
      public boolean allDifferent$mZc$sp(boolean, boolean, boolean);
      public boolean allDifferent$mBc$sp(byte, byte, byte);
      public boolean allDifferent$mCc$sp(char, char, char);
      public boolean allDifferent$mDc$sp(double, double, double);
      public boolean allDifferent$mFc$sp(float, float, float);
      public boolean allDifferent$mIc$sp(int, int, int);
      public boolean allDifferent$mJc$sp(long, long, long);
      public boolean allDifferent$mSc$sp(short, short, short);
      public boolean allDifferent$mVc$sp(scala.runtime.BoxedUnit, scala.runtime.BoxedUnit, scala.runtime.BoxedUnit);
      ...
  }
  */
}
