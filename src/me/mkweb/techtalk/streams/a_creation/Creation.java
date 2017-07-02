package me.mkweb.techtalk.streams.a_creation;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static java.util.Arrays.asList;

/**
 * @author Mario Kunz
 */
@SuppressWarnings("ALL")
public class Creation {
    private static final List<String> list = asList("a", "b", "c", "d", "e");
    private static final Deque<String> linkedList = new LinkedList<>(asList("f", "g", "h", "i", "j"));
    private static final String[] array = new String[]{"a", "b", "c"};

    public static void main(String[] args) {
        // region Array
        Stream<String> arrayStream = Arrays.stream(array);
        print(arrayStream);
        // endregion

        // region Collection
        // stream is defined in the Collection interface and every subclass implements it
        Stream<String> streamFromCollection = list.stream();
        Stream<String> streamFromDeque = linkedList.stream();
        print(streamFromCollection);
        print(streamFromDeque);
        // endregion

        // region Stream interface
        Stream<String> singleValueStream = Stream.of("a");
        Stream<String> multiValueStream = Stream.of("a", "b", "c");
        Stream<String> concatenatedStream = Stream.concat(singleValueStream, multiValueStream);
        print(concatenatedStream);

        Stream<Object> emptyStream = Stream.empty();
        print(emptyStream);

        Stream<Double> streamFromSupplier = Stream.generate(() -> Math.random()).limit(20);
        print(streamFromSupplier);

        Stream<Integer> streamFromIterate = Stream.iterate(1, n -> n * 2).limit(20);
        print(streamFromIterate);

        Stream<Object> streamFromBuilder = Stream.builder()
                .add("a")
                .add("b")
                .build();
        print(streamFromBuilder);
        // endregion

        // region StreamSupport
        Stream<String> fromSpliterator = StreamSupport.stream(list.spliterator(), false);
        print(fromSpliterator);
        // StreamSupport has also other similar creation methods for intStream, doubleStream etc.
        // but the StreamSupport class is actually not intended to be used in code other than Utilities and Libraries
        // endregion

        // region Parallel Stream
        Stream<String> parallelStreamOfList = list.parallelStream()
                .map(s -> String.format("%s: %s", Thread.currentThread().getName(), s));
        print(parallelStreamOfList);

        Stream<String> parallelMultiValueStream = Stream.of("p", "a", "r", "a", "l", "l", "e", "l")
                .parallel()
                .map(s -> String.format("%s: %s", Thread.currentThread().getName(), s));
        print(parallelMultiValueStream);
        // endregion
    }

    private static <T> void print(Stream<T> stream) {
        stream.forEach(System.out::println);
        System.out.println("---------");
    }
}
