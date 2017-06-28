package me.mkweb.techtalk.streams.z_complex_examples;

import java.util.StringTokenizer;
import java.util.stream.Stream;

public class ComplexStreamExamples {
    public static void main(String[] args) {
        Stream.of("BIT ", " Truly Rocks")
                .map(String::trim)
                .map(StringTokenizer::new)
                .flatMap(ComplexStreamExamples::getAllTokens)
                .forEach(System.out::println);
    }

    private static Stream<String> getAllTokens(StringTokenizer tokenizer) {
        Stream.Builder<String> streamBuilder = Stream.builder();
        while (tokenizer.hasMoreTokens()) {
            streamBuilder.accept(tokenizer.nextToken());
        }
        return streamBuilder.build();
    }
}
