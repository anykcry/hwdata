package com.huawei.it.hwdata.util;



import org.springframework.core.convert.converter.Converter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter implements Converter<String,Date> {



    public DateConverter(String datePattern) {


        try{

            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        }catch(Exception ex){

            System.out.println("----sdf-sf-sf-sd-s-f");
        }


    }

    public Date convert(String s) {

        Date date=null;
        try{

            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            date = sf.parse(s);
        }catch(Exception ex){

            System.out.println("----sdf-sf-sf-sd-s-f");
        }

        return date;
    }
}
