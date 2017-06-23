package me.mkweb.techtalk.util.model;

import java.time.LocalDate;

/**
 * @author Mario Kunz
 */
public class Order {
    private Customer customer;
    private Employee assignedTo;
    private String description;
    private Company company;
    private LocalDate createdAt;
    private boolean finished;

    public Order() {
    }

    public Order(Customer customer, Employee assignedTo, String description) {
        this.customer = customer;
        this.assignedTo = assignedTo;
        this.description = description;
        this.company = assignedTo.getEmployer();
        this.createdAt = LocalDate.now();
        this.finished = false;
    }

    public void finish() {
        this.finished = true;
    }

    @Override
    public String toString() {
        return "Order{" +
                "customer=" + customer +
                ", assignedTo=" + assignedTo +
                ", description='" + description + '\'' +
                ", company=" + company +
                '}';
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Employee getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(Employee assignedTo) {
        this.assignedTo = assignedTo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public boolean isFinished() {
        return finished;
    }
}
