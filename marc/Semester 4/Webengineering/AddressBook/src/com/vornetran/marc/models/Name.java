package com.vornetran.marc.models;

/**
 * Created by Marc on 04.05.2015.
 */
public class Name {

    public String addressForm;
    public String firstName;
    public String lastName;

    public Name(){};

    public Name(String addressForm, String firstName, String lastName){
        this.addressForm = addressForm;
        this.firstName = firstName;
        this.lastName = lastName;
    }

}
