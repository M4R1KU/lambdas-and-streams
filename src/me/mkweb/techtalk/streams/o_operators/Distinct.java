package me.mkweb.techtalk.streams.o_operators;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Distinct {
    public static void main(String[] args) {
        int[] distinctInts = IntStream.of(1, 2, 3, 4, 2, 5, 1)
                .distinct().toArray();

        System.out.println(Arrays.toString(distinctInts));
    }
}
