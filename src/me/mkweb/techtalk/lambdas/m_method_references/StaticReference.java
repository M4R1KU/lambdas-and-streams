package me.mkweb.techtalk.lambdas.m_method_references;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author Mario Kunz
 */
public class StaticReference {
    public static void main(String[] args) {
        Function<String[], String> concater = StaticReference::concatArgs;

        System.out.println(concater.apply(new String[]{"Hei", "you", "are", "cool"}));
    }

    private static String concatArgs(String... args) {
        return Arrays.stream(args).collect(Collectors.joining(" "));
    }
}
