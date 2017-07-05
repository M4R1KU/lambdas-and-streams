package me.mkweb.techtalk.util.model;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Mario Kunz
 */
public class Person {
    private String firstName;
    private String secondName;
    private Address address;
    private int age;

    public Person() {
    }

    public Person(String firstName, String secondName, int age) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
    }

    public Person(String firstName, String secondName, Address address, int age) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.address = address;
        this.age = age;
    }

    public String getFullName() {
        return firstName + " " + secondName;
    }

    @Override
    public String toString() {
        return "Person {" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", address=" + address +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (age != person.age) return false;
        if (firstName != null ? !firstName.equals(person.firstName) : person.firstName != null) return false;
        if (secondName != null ? !secondName.equals(person.secondName) : person.secondName != null) return false;
        return address != null ? address.equals(person.address) : person.address == null;
    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (secondName != null ? secondName.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + age;
        return result;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
