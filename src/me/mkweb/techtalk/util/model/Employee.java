package me.mkweb.techtalk.util.model;

/**
 * @author Mario Kunz
 */
public class Employee extends Person {
    private double salary;
    private Company employer;

    public Employee() {
    }

    public Employee(String firstName, String secondName, Address address, int age, double salary) {
        super(firstName, secondName, address, age);
        this.salary = salary;
    }

    public Employee(String firstName, String secondName, Address address, int age, double salary, Company employer) {
        super(firstName, secondName, address, age);
        this.salary = salary;
        this.employer = employer;
    }

    @Override
    public String toString() {
        return "Employee{" + super.toString() +
                ", employer=" + employer +
                ", salary=" + salary +
                '}';
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Company getEmployer() {
        return employer;
    }

    public void setEmployer(Company employer) {
        this.employer = employer;
    }
}
