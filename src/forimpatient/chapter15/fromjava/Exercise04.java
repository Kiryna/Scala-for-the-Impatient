package forimpatient.chapter15.fromjava;

import static forimpatient.chapter15.Exercise04.sum;

/**
 * Created by Iryna Kharaborkina on 8/13/16.
 *
 * Solution to the Chapter 15 Exercise 04 'Scala for the Impatient' by Horstmann C.S.
 *
 * Write a Scala method sum with variable integer arguments that returns the sum of its arguments. Call it from Java.
 */
public class Exercise04 {
    public static void main(String[] args) {
        System.out.println(sum(1, 2, 3));
        System.out.println(sum(1, 2, 3, 4, 5));
    }
}
