package com.vornetran.marc.models;

/**
 * Created by Marc on 04.05.2015.
 */
public class Location {

    public Street street;
    public City city;
    public String country;

    public Location(){
        this.street = new Street();
        this.city = new City();
    };

    public Location(Street street, City city, String country){
        this.street = street;
        this.city = city;
        this.country = country;
    }

}
