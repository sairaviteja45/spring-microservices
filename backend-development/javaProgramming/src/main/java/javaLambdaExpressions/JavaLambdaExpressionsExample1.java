package javaLambdaExpressions;

public class JavaLambdaExpressionsExample1 {

    /* 1.Lambda Expressions in Java cannot be used with normal interfaces, i.e, interfaces that have more than one abstract method. */
    /* 2.In Java Lambda Expressions can only be used with functional interfaces. */
    /* 3.A Functional Interface is an interface that has exactly one abstract method. */
    /* 4.This is because a Lambda Expression provides an implementation for a single method, which makes it compatible with functional interfaces. */

    /* Example: - */
    /*  Runnable runnable = () -> System.out.println("Running"); */

    /* 5.If an Interface has more than one abstract method, it is not a functional interface, and lambda expressions cannot be used to implement it directly. */
    /* 6.In such cases you need to provide a concrete implementation of interface using a class or an anonymous inner class. */

    /* Lambda Expression Example: - */

    /** Static Method for Using Functional Interface. **/
    public static void LambdaExpressions() {

        Calculation add = Integer::sum;

        Calculation addition = (a, b) -> a + b;

        Calculation subtraction = (a, b) -> a - b;

        System.err.println("Addition: " + add.calcuate(5, 10));
        System.err.println("Subtraction: " + subtraction.calcuate(10, 5));
    }
}

/** Interface With One Abstract Method. **/
@FunctionalInterface
interface Calculation {
    int calcuate(int a, int b);
}
