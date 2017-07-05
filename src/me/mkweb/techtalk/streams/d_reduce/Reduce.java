package me.mkweb.techtalk.streams.d_reduce;

import java.util.stream.IntStream;

/**
 * @author Mario Kunz
 */
public class Reduce {
    public static void main(String[] args) {
        int result = IntStream.of(3, 5)
                .reduce(0, (a, b) -> a + b);
        System.out.println(result);

        // is equivalent

        result = IntStream.of(3, 5).sum();

        System.out.println(result);
    }
}
