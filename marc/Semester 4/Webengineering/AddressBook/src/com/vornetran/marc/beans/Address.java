package com.vornetran.marc.beans;

import com.vornetran.marc.database.Database;
import com.vornetran.marc.database.Sequelize;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

/**
 * Created by Marc on 30.04.2015.
 */
public class Address {

    private Sequelize db = Database.get();

    private int id;
    private String name;
    private String christianName;
    private String addressForm;
    private String email;
    private String phone;
    private String mobile;
    private String street;
    private int number;
    private String city;
    private String postcode;
    private String country;
    private Date birthday;

    public void setId(int id){
        this.id = id;
    }

    public void read(){
        String sql = "SELECT * FROM address WHERE id = ?;";

        try(PreparedStatement statement = this.db.prepare(sql)){
            statement.setInt(1, id);

            ResultSet result = statement.executeQuery();

            if(result.next()){
                this.name = result.getString("name");
                this.christianName = result.getString("christianname");
                this.addressForm = result.getString("addressform");
                this.email = result.getString("email");
                this.phone = result.getString("phone");
                this.mobile = result.getString("mobile");
                this.street = result.getString("street");
                this.number = result.getInt("number");
                this.city = result.getString("city");
                this.postcode = result.getString("postcode");
                this.country = result.getString("country");
                this.birthday = result.getDate("birthday");
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    public void save(){
        String sql = "UPDATE address SET name = ?, christianname = ?, addressform = ?, email = ?, phone = ?, mobile = ?, street = ?, number = ?, city = ?, postcode = ?, country = ?, birthday = ? WHERE id = ?;";

        try(PreparedStatement statement = this.db.prepare(sql)){
            int j = 1;
            statement.setString(j++, this.name);
            statement.setString(j++, this.christianName);
            statement.setString(j++, this.addressForm);
            statement.setString(j++, this.email);
            statement.setString(j++, this.phone);
            statement.setString(j++, this.mobile);
            statement.setString(j++, this.street);
            statement.setInt(j++, this.number);
            statement.setString(j++, this.city);
            statement.setString(j++, this.postcode);
            statement.setString(j++, this.country);
            statement.setDate(j++, this.birthday);
            statement.setInt(j++, this.id);

            statement.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    public int getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public String getChristianName() {
        return christianName;
    }

    public String getAddressForm() {
        return addressForm;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getMobile() {
        return mobile;
    }

    public String getStreet() {
        return street;
    }

    public int getNumber() {
        return number;
    }

    public String getCity() {
        return city;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getCountry() {
        return country;
    }

    public String getBirthday() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("d. MMMM y");

        return dateFormat.format(this.birthday);
    }

}
