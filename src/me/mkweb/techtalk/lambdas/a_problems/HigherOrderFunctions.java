package me.mkweb.techtalk.lambdas.a_problems;

import me.mkweb.techtalk.util.internal.CustomerRepository;
import me.mkweb.techtalk.util.model.Person;

import java.util.function.Function;

/**
 * @author Mario Kunz
 */
@SuppressWarnings("ALL")
public class HigherOrderFunctions {
    private static CustomerRepository customerRepository = CustomerRepository.INSTANCE;

    public static void main(String[] args) {
        Function<Integer, Integer> fn = addTo(3);

        System.out.println("We expect 3 + 5 = 8");
        System.out.printf("Result: %s\n", fn.apply(5));
        //Now we could apply any Integers to our generated function
        fn.apply(1344);
        fn.apply(12);
        fn.apply(99);
        // etc.

        //-------
        Person p = customerRepository.findOne(1).orElseThrow(IllegalStateException::new);
        String countryName = extract(person -> person.getAddress().getCountry(), p);
        String firstName = extract(Person::getFirstName, p); // With Method Reference
        System.out.printf("The country of %s is %s", firstName, countryName);
    }

    /**
     * Higher order function that returns a function which takes an Integer as argument
     */
    private static Function<Integer, Integer> addTo(int value) {
        return (add) -> add + value;
    }

    /**
     * Higher order function that takes a function as argument
     * Extracts something from the person object if it is not null
     */
    private static <T> T extract(Function<Person, T> extractor, Person person) {
        if (person == null) {
            throw new IllegalStateException("Person is null");
        }
        return extractor.apply(person);
    }
}
