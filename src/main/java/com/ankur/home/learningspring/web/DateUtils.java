package com.ankur.home.learningspring.web;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    private static final DateFormat dateFormat =new SimpleDateFormat("yyyy-MM-dd");

    public static final Date createDateFromDateString(String dateString){
        Date date=null;
        if(dateString != null){
            try{
            date= dateFormat.parse(dateString);
            }catch(ParseException pe){
                date=new Date();
            }
        }else{
            date=new Date();
        }
        return date;
    }
    
}
