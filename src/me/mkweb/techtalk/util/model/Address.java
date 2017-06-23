package me.mkweb.techtalk.util.model;

/**
 * @author Mario Kunz
 */
public class Address {
    private String street;
    private int houseNumber;
    private String streetSupplement;
    private String city;
    private String state;
    private int postalCode;
    private String country;

    public Address() {
    }

    public Address(String street, int houseNumber, String city, String state, int postalCode, String country) {
        this.street = street;
        this.houseNumber = houseNumber;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.country = country;
    }

    public Address(String street, int houseNumber, String streetSupplement, String city, String state, int postalCode, String country) {
        this.street = street;
        this.houseNumber = houseNumber;
        this.streetSupplement = streetSupplement;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.country = country;
    }

    @Override
    public String toString() {
        return "Address {" +
                "street='" + street + '\'' +
                ", houseNumber=" + houseNumber +
                ", streetSupplement='" + streetSupplement + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", postalCode=" + postalCode +
                ", country='" + country + '\'' +
                '}';
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getStreetSupplement() {
        return streetSupplement;
    }

    public void setStreetSupplement(String streetSupplement) {
        this.streetSupplement = streetSupplement;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
