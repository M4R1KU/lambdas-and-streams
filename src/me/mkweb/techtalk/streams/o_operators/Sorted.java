package me.mkweb.techtalk.streams.o_operators;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Sorted {
    public static void main(String[] args) {
        // use natural order
        String sortedString = Stream.of("f", "c", "a", "z", "p")
                .sorted()
                .collect(Collectors.joining(", "));

        System.out.println(sortedString);

        // use a comparable class
        String sortedCompares = Stream.of(new Compare(100), new Compare(112), new Compare(1), new Compare(12))
                .sorted()
                .map(Compare::getValue)
                .map(Object::toString)
                .collect(Collectors.joining("-"));

        System.out.println(sortedCompares);

        // parse a comparator to sorted
        String sortedInts = IntStream.of(13, 342, 3, 45, 12).boxed()
                .sorted(Comparator.reverseOrder())
                .map(Object::toString)
                .collect(Collectors.joining("-"));
        System.out.println(sortedInts);
    }

    /**
     * A class that implements the {@link Comparable} interface can be sorted in a stream
     */
    private static class Compare implements Comparable<Compare> {
        private int value;

        public Compare(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        @Override
        public int compareTo(@NotNull Compare o) {
            return Integer.compare(this.value, o.getValue());
        }
    }
}
