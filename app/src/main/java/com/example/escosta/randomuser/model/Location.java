package com.example.escosta.randomuser.model;

/**
 * Created by escosta on 16/05/2017.
 */
public class Location {

    public String street;
    public String city;
    public String state;
    public int postcode;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city.replaceFirst(city.substring(0,1), city.substring(0,1).toUpperCase());
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state.replaceFirst(state.substring(0,1), state.substring(0,1).toUpperCase());
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getPostcode() {
        return postcode;
    }

    public void setPostcode(int postcode) {
        this.postcode = postcode;
    }
}
