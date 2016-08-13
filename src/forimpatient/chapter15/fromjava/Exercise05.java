package forimpatient.chapter15.fromjava;

import static forimpatient.chapter15.Exercise05.getFileLines;
/**
 * Created by Iryna Kharaborkina on 8/13/16.
 *
 * Solution to the Chapter 15 Exercise 05 'Scala for the Impatient' by Horstmann C.S.
 *
 * Write a Scala method that returns a string containing all lines of a file. Call it from Java.
 */
public class Exercise05 {
    public static void main(String[] args) {
        System.out.println(getFileLines("LICENSE"));
    }
}
