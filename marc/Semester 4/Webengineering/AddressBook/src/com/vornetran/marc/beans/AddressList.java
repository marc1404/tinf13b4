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

    private String[] searchableColumns = { "name", "christianname", "email", "phone", "mobile", "street", "city", "country" };
    private String search;

    public void setSearch(String search){
        this.search = search;
    }

    public List<Address> getList(){
        List<Address> addresses = new ArrayList<Address>();
        String sql = "SELECT * FROM address";

        if(search != null){
            sql += where();
        }

        try(PreparedStatement statement = db.prepare(sql)){
            if(search != null) {
                for (int i = 0; i < searchableColumns.length; i++) {
                    statement.setString(i + 1, "%" + this.search + "%");
                }
            }

            ResultSet result = statement.executeQuery();

            while(result.next()){
                addresses.add(new Address(result));
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }

        return addresses;
    }

    public void delete(){

    }

    private String where(){
        String where = " WHERE ";

        for(int i = 0; i < searchableColumns.length; i++){
            String column = searchableColumns[i];
            where += column + " LIKE ?";

            if(i < searchableColumns.length - 1){
                where += " OR ";
            }
        }

        return where;
    }

}
