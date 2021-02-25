package com.company;
import java.util.ArrayList;

class AddressEntry {
    public static AddressEntry test;
    String firstName;
    String lastName;
    String street;
    String city;
    String state;
    int zip;
    String phone;
    String email;

    public AddressEntry(String firstName, String lastName, String street, String city, String state, int zip, String email, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone = phone;
        this.email = email;
    }

    /**
     * @param firstName
     * **/
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    /**
     * @param lastName
     * **/
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    /**
     * @param street
     * **/
    public void setStreet (String street) {
        this.street = street;
    }
    /**
     * @param city
     * **/
    public void setCity(String city) {
        this.city = city;
    }
    /**
     * @param state
     * **/
    public void setState(String state) {
        this.state = state;
    }
    /**
     * @param zip
     * **/
    public void setZip(int zip) {
        this.zip = zip;
    }
    /**
     * @param phone
     * **/
    public void setPhone(String phone) {
        this.phone = phone;
    }
    /**
     * @param email
     * **/
    public void setEmail(String email) {
        this.email = email;
    }


    /**
     * @return firstName
     * **/
    public String getFirstName() {
        return firstName;
    }
    /**
     @return lastName
     **/
    public String getLastName() {
        return lastName;
    }
    /**
     @return street
     **/
    public String getStreet() {
        return street;
    }
    /**
     @return city
     **/
    public String getCity() {
        return city;
    }
    /**
     @return state
     **/
    public String getState() {
        return state;
    }
    /**
     @return zip
     **/
    public int getZip() {
        return zip;
    }
    /**
     @return phone
     **/
    public String getPhone() {
        return phone;
    }
    /**
     @return email
     **/
    public String getEmail() {
        return email;
    }


    /**
     @return s
     **/
    @Override
    public String toString() {
        String s = firstName + " " + lastName + "\n" + street + "\n" + city + ", " + state + " " + zip + "\n" + email + "\n" + phone;
        return s;
    }
    //how to turn into a list?
}
