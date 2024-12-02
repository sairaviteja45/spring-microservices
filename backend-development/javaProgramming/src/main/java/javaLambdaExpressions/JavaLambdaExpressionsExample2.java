package javaLambdaExpressions;

public class JavaLambdaExpressionsExample2 {

    /* EXAMPLE OF AN INTERFACE WHERE LAMBDA CANNOT BE USED. */
    /* 1.An Interface MultiFunction with more than one abstract method. */
    /* 2.Since MultiFunction has two abstract methods (method-1 and method-2). */
    /* 3.It is not a Functional Interface, and you cannot use a lambda expressions to implement it. */
    /* 4.You need to use an anonymous inner class or a concrete class. */
    /* 5.In this example, an anonymous inner class is used to provide implementations for both method1 and method2. */
    /* 6.As a Lambda Expression would not be applicable due to the presence of more than abstract method. */

    /** Static Method is Created for Using Interface With More than One Abstract Method. **/
    public static void callingMultiFunctionInterface() {
        MultiFunction multiFunction = new MultiFunction() {
            @Override
            public void method2() {
                System.err.println("Method 2 is Executed Successfully...");
            }
            @Override
            public void method1() {
                System.err.println("Method 1 is Executed Successfully...");
            }
        };

        multiFunction.method1();
        multiFunction.method2();
    }
}

/** Interface With More than one Abstract Method. **/
interface MultiFunction {
    void method1();
    void method2();
}
