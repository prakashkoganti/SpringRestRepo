package com.java.spring.service;

import java.util.Date;

import com.java.spring.utils.EmpUtils;

public class Test {

	public static void main(String[] args) {

		String d="12/14";
		Date dat=EmpUtils.convertStringToDate(d);
		System.out.println(dat.toString());
	}

}
