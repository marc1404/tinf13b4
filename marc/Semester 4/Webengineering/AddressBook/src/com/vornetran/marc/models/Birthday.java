package com.vornetran.marc.models;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by Marc on 04.05.2015.
 */
public class Birthday {

    public Date date;

    public Birthday(){};

    public Birthday(Date date){
        this.date = date;
    }

    public Birthday(String dateText) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("y-MM-dd");
        this.date = new Date(dateFormat.parse(dateText).getTime());
    }

    public String display(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("d. MMMM y");

        return dateFormat.format(this.date);
    }

}
