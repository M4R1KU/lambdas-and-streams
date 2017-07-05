package me.mkweb.techtalk.lambdas.m_method_references;

import me.mkweb.techtalk.util.model.Person;

import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author Mario Kunz
 */
public class ObjectMethodReference {
    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder("Name: ");
        Function<String, StringBuilder> appender = builder::append;
        System.out.println(appender.apply("Mario").toString());
        System.out.println(appender.apply(" Kunz").toString());

        Person person = new Person("Ueli", "Maurer", 66);
        Supplier<String> fullNameSupplier = person::getFullName;
        System.out.println(fullNameSupplier.get());
    }
}
