package me.mkweb.techtalk.streams.x_missing_features;

import me.mkweb.techtalk.util.model.Person;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author Joel Messerli @02.07.2017
 */
public class MissingStdFeatures {
    public static void main(String[] args) {
        Person p1 = new Person("Joel", "Messerli", null, 0);
        Person p2 = new Person("Mario", "Kunz", null, 0);
        Person p3 = new Person("Franz", "Messerli", null, 0);

        Arrays.asList(p1, p2, p3).stream()
                .filter(distinctByKey(Person::getSecondName))
                .forEach(System.out::println);
    }

    public static <T, E> Predicate<T> distinctByKey(Function<T, E> keyExtractor) {
        Map<E, Boolean> existsMap = new ConcurrentHashMap<>();
        return (element) -> existsMap.putIfAbsent(keyExtractor.apply(element), Boolean.TRUE) == null;
    }
}
