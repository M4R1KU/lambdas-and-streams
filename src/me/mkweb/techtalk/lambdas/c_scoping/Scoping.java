package me.mkweb.techtalk.lambdas.c_scoping;

import java.util.function.IntUnaryOperator;

/**
 * @author Mario Kunz
 */
public class Scoping {
    public static void main(String[] args) {
        int x = 100;
        IntUnaryOperator op = y -> y * x;
        // uncomment the line below the get the compiler error
        //x = 10;
        int result = op.applyAsInt(10);
        System.out.println(result);
    }
}
