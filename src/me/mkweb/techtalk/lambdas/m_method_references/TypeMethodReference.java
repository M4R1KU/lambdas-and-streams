package me.mkweb.techtalk.lambdas.m_method_references;

import me.mkweb.techtalk.util.model.Person;

import java.util.function.Function;

/**
 * @author Mario Kunz
 */
public class TypeMethodReference {
    public static void main(String[] args) {
        Person person = new Person("Giovanni", "Conti", 54);
        Function<Person, String> getFullName = Person::getFullName;
        System.out.println(getFullName.apply(person));
    }
}
