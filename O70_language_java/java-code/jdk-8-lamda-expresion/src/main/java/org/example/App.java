package org.example;

import java.util.function.IntBinaryOperator;

/**
 * Hello world!
 */
public class App {

    interface FuncInter1 {
        // operation is implemented using lambda expressions
        int operation(int arg1, int arg2);
    }

    interface FuncInter2 {
        void saidHello(String message);
    }

    // Performs FuncInter1's operation on 'a' and 'b'
    private static int operation(int arg1, int arg2, FuncInter1 func) {
        return func.operation(arg1, arg2);
    }

    public static void main(String[] args) {

        // lambda expression for addition for two parameters
        // data type for x and y is optional.
        // This expression implements 'FuncInter1' interface
        FuncInter1 add = (int x, int y) -> x + y;
        System.out.println(add.operation(3, 4));

        // lambda expression multiplication for two
        // parameters This expression also implements
        // 'FuncInter1' interface
        FuncInter1 mul = (int x, int y) -> x * y;


        System.out.println(operation(4, 5, (int x, int y) -> x - y));


    }
}
