package com.solvd.bookingservice.jaxb;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.util.Date;

public class DateAdapter extends XmlAdapter <String, Date> {
    public Date unmarshal(String date) throws ParseException {
        return new SimpleDateFormat("MM-dd-yyyy").parse(date);
    }
    public String marshal (Date d){
        return new SimpleDateFormat("MM-dd-yyyy").format(d);
    }
}
