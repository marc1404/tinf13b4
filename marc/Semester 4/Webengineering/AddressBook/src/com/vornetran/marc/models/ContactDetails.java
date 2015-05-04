package com.vornetran.marc.models;

/**
 * Created by Marc on 04.05.2015.
 */
public class ContactDetails {

    public String email;
    public String phone;
    public String mobile;

    public ContactDetails(){};

    public ContactDetails(String email, String phone, String mobile){
        this.email = email;
        this.phone = phone;
        this.mobile = mobile;
    }

}
