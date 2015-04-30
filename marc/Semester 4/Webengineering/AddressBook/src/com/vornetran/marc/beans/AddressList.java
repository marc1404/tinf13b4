package com.vornetran.marc.beans;

import com.vornetran.marc.database.Database;
import com.vornetran.marc.database.Sequelize;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marc on 30.04.2015.
 */
public class AddressList {

    private Sequelize db = Database.get();

    private String search;

    public void setSearch(String search){
        this.search = search;
    }

    public List<Address> getList(){
        List<Address> addresses = new ArrayList<Address>();
        String sql = "SELECT id FROM address;";

        try(PreparedStatement statement = db.prepare(sql)){
            ResultSet result = statement.executeQuery();

            while(result.next()){
                Address address = new Address();
                int id = result.getInt("id");

                address.setId(id);
                address.read();
                addresses.add(address);
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }

        return addresses;
    }

    public void delete(){

    }

}
