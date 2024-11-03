package com.anki.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormat {

	
	public Date formateDate(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date data = new Date();
        String formattedDate = formatter.format(date);
        Date parsedDate=null;
		try {
			parsedDate = formatter.parse(formattedDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
        System.out.println("Parsed Date: " + parsedDate);
        
		return parsedDate;
		
		
	}
}
