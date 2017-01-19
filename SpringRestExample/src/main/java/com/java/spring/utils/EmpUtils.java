package com.java.spring.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EmpUtils {

	public static String convertDateToString(Date date){
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		return sdf.format(date);
	}

	public static Date convertDateToString(String date){
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		Date returndate=null;
		try {
			returndate = sdf.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returndate;
	}
	public static Date convertStringToDate(String date){
		SimpleDateFormat sdf=new SimpleDateFormat("MM/dd");
		SimpleDateFormat sdf2=new SimpleDateFormat("dd/MM/yyyy");
		Date returndate=null;
		try {
			returndate = sdf.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returndate;
		
	}
}
