package me.mkweb.techtalk.streams.c_collectors;

import me.mkweb.techtalk.util.model.Person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class NestedCollectorsExample {
    private static List<Person> people = new ArrayList<>();

    static {
        people.add(new Person("Joel", "Messerli", null, 0));
        people.add(new Person("Mario", "Kunz", null, 0));
        people.add(new Person("Franz", "Messerli", null, 0));
    }

    public static void main(String[] args) {
        Map<String, List<String>> secondToFirstNames = newSecondToFirstNameMap();
        System.out.println(secondToFirstNames);

        Map<String, List<String>> oldSecondToFirstNames = oldSecondToFirstNameMap();
        System.out.println(oldSecondToFirstNames);
    }

    private static Map<String, List<String>> newSecondToFirstNameMap() {
        return people.stream()
                .collect(Collectors.groupingBy(
                        Person::getSecondName,
                        Collectors.mapping(Person::getFirstName, Collectors.toList())
                ));
    }

    private static Map<String, List<String>> oldSecondToFirstNameMap() {
        Map<String, List<String>> oldSecondToFirstNames = new HashMap<>();
        for (Person person : people) {
            String firstName = person.getFirstName();
            String secondName = person.getSecondName();

            if (!oldSecondToFirstNames.containsKey(secondName)) {
                ArrayList<String> firstNameList = new ArrayList<>();
                firstNameList.add(firstName);
                oldSecondToFirstNames.put(secondName, firstNameList);
            } else {
                oldSecondToFirstNames.get(secondName).add(firstName);
            }
        }
        return oldSecondToFirstNames;
    }
}
