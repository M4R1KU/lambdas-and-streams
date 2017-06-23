package me.mkweb.techtalk.util.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mario Kunz
 */
public class Customer extends Person {
    private List<Order> orders;

    public Customer() {
        orders = new ArrayList<>();
    }

    public Customer(String firstName, String secondName, Address address, int age, List<Order> orders) {
        super(firstName, secondName, address, age);
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Customer{" + super.toString() +
                "orders=" + orders +
                '}';
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
