package me.mkweb.techtalk.streams.o_operators;

import me.mkweb.techtalk.util.Mock;
import me.mkweb.techtalk.util.Repository;
import me.mkweb.techtalk.util.internal.CustomerRepository;
import me.mkweb.techtalk.util.model.Customer;

public class Filter {
    private static Repository<Customer> customerRepository = CustomerRepository.INSTANCE;

    public static void main(String[] args) {
        Mock.init();

        customerRepository.findAll().stream()
                .filter(customer -> customer.getAge() > 20)
                .forEach(System.out::println);
    }
}
