package me.mkweb.techtalk.streams.b_old_vs_new;

import me.mkweb.techtalk.util.Mock;
import me.mkweb.techtalk.util.internal.CustomerRepository;
import me.mkweb.techtalk.util.model.Address;
import me.mkweb.techtalk.util.model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Mario Kunz
 */
public class OldVsNew {
    private static CustomerRepository customerRepository = CustomerRepository.INSTANCE;

    public static void main(String[] args) {
        Mock.init();

        System.out.println("Old Way");
        System.out.println(getListOfHouseNumbersOfCustomersOfNewBernOldWay());
        System.out.println("----- \nNew Way");
        System.out.println(getListOfHouseNumbersOfCustomersOfNewBernNewWay());
    }

    public static List<Integer> getListOfHouseNumbersOfCustomersOfNewBernOldWay() {
        List<Integer> houseNumbers = new ArrayList<>();
        for (Person person : customerRepository.findAll()) { // IntelliJ should show a hint here
            if (person.getAddress().getCity().equals("New Bern")) {
                houseNumbers.add(person.getAddress().getHouseNumber());
            }
        }
        return houseNumbers;
    }

    public static List<Integer> getListOfHouseNumbersOfCustomersOfNewBernNewWay() {
        return customerRepository.findAll().stream()
                .map(Person::getAddress)
                .filter(address -> address.getCity().equals("New Bern"))
                .map(Address::getHouseNumber)
                .collect(Collectors.toList());
    }
}
