package com.vornetran.marc.beans;

import com.vornetran.marc.database.Database;
import com.vornetran.marc.database.Sequelize;
import com.vornetran.marc.models.*;

import java.sql.*;

/**
 * Created by Marc on 30.04.2015.
 */
public class Address {

    private Sequelize db = Database.get();

    private Integer id;
    private Name name;
    private Location location;
    private ContactDetails contactDetails;
    private Birthday birthday;
    private boolean exists = false;

    public Address(){
        this.name = new Name();
        this.location = new Location();
        this.contactDetails = new ContactDetails();
        this.birthday = new Birthday();
    }

    public Address(int id){
        this.id = id;
    }

    public Address(ResultSet result) throws SQLException {
        readRow(result);
    }

    public Address(Integer id, Name name, Location location, ContactDetails contactDetails, Birthday birthday){
        this.id = id;
        this.name = name;
        this.location = location;
        this.contactDetails = contactDetails;
        this.birthday = birthday;
    }

    public void parseId(String id){
        try {
            this.id = Integer.parseInt(id);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public void setId(int id){
        this.id = id;
    }

    public void read(){
        if(this.id == null){
            return;
        }

        String sql = "SELECT * FROM address WHERE id = ? LIMIT 1;";

        try(PreparedStatement statement = this.db.prepare(sql)){
            statement.setInt(1, id);

            ResultSet result = statement.executeQuery();

            if(result.next()){
                readRow(result);
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    public boolean save(){
        if(id != null){
            return update();
        }else{
            return insert();
        }
    }

    public void delete(){
        String sql = "DELETE FROM address WHERE id = ? LIMIT 1;";

        try(PreparedStatement statement = this.db.prepare(sql)){
            statement.setInt(1, this.id);
            statement.executeUpdate();
            System.out.println(sql + id);
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    public Integer getId(){
        return id;
    }

    public String getName() {
        return name.lastName;
    }

    public String getChristianName() {
        return name.firstName;
    }

    public String getAddressForm() {
        return name.addressForm;
    }

    public String getEmail() {
        return contactDetails.email;
    }

    public String getPhone() {
        return contactDetails.phone;
    }

    public String getMobile() {
        return contactDetails.mobile;
    }

    public String getStreet() {
        return location.street.name;
    }

    public int getNumber() {
        return location.street.number;
    }

    public String getCity() {
        return location.city.name;
    }

    public String getPostcode() {
        return location.city.postCode;
    }

    public String getCountry() {
        return location.country;
    }

    public String displayBirthday() {
        return birthday.display();
    }

    public Date getBirthday() {
        return birthday.date;
    }

    public boolean exists(){
        return this.exists;
    }

    private void readRow(ResultSet result) throws SQLException {
        this.id = result.getInt("id");
        this.name = new Name(result.getString("addressform"), result.getString("christianname"), result.getString("name"));
        Street street = new Street(result.getString("street"), result.getInt("number"));
        City city = new City(result.getString("postcode"), result.getString("city"));
        String country = result.getString("country");
        this.location = new Location(street, city, country);
        this.contactDetails = new ContactDetails(result.getString("email"), result.getString("phone"), result.getString("mobile"));
        this.birthday = new Birthday(result.getDate("birthday"));
        this.exists = true;
    }

    private boolean update(){
        String sql = "UPDATE address SET name = ?, christianname = ?, addressform = ?, email = ?, phone = ?, mobile = ?, street = ?, number = ?, city = ?, postcode = ?, country = ?, birthday = ? WHERE id = ?;";

        try(PreparedStatement statement = this.db.prepare(sql)){
            int j = 1;

            statement.setString(j++, name.lastName);
            statement.setString(j++, name.firstName);
            statement.setString(j++, name.addressForm);
            statement.setString(j++, contactDetails.email);
            statement.setString(j++, contactDetails.phone);
            statement.setString(j++, contactDetails.mobile);
            statement.setString(j++, location.street.name);
            statement.setInt(j++, location.street.number);
            statement.setString(j++, location.city.name);
            statement.setString(j++, location.city.postCode);
            statement.setString(j++, location.country);
            statement.setDate(j++, birthday.date);
            statement.setInt(j++, this.id);

            statement.executeUpdate();

            return true;
        }catch(SQLException ex){
            ex.printStackTrace();
            return false;
        }
    }

    private boolean insert(){
        String sql = "INSERT INTO address (addressform, christianname, name, street, number, postcode, city, country, email, phone, mobile, birthday) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

        try(PreparedStatement statement = this.db.prepare(sql, Statement.RETURN_GENERATED_KEYS)){
            int j = 1;

            statement.setString(j++, name.addressForm);
            statement.setString(j++, name.firstName);
            statement.setString(j++, name.lastName);
            statement.setString(j++, location.street.name);
            statement.setInt(j++, location.street.number);
            statement.setString(j++, location.city.postCode);
            statement.setString(j++, location.city.name);
            statement.setString(j++, location.country);
            statement.setString(j++, contactDetails.email);
            statement.setString(j++, contactDetails.phone);
            statement.setString(j++, contactDetails.mobile);
            statement.setDate(j++, birthday.date);

            statement.executeUpdate();

            ResultSet generatedKeys = statement.getGeneratedKeys();

            generatedKeys.next();

            this.id = generatedKeys.getInt(1);
            this.exists = true;

            return true;
        }catch(SQLException ex){
            ex.printStackTrace();
            return false;
        }
    }

}
