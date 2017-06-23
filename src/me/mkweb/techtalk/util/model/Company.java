package me.mkweb.techtalk.util.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mario Kunz
 */
public class Company {
    private String name;
    private List<Employee> employees;
    private List<Customer> customers;

    public Company() {
        employees = new ArrayList<>();
        customers = new ArrayList<>();
    }

    public Company(String name, List<Employee> employees, List<Customer> customers) {
        this();
        this.name = name;
        this.customers = customers;
        employees.forEach(this::hire);
    }

    public void hire(Employee person) {
        person.setEmployer(this);
        employees.add(person);
    }

    public void fire(Employee person) {
        employees.remove(person);
    }

    public void newCustomer(Customer person) {
        customers.add(person);
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", employees=" + employees +
                ", customers=" + customers +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
}
