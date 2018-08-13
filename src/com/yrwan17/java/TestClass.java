package com.yrwan17.java;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class TestClass {

	@Test
	public void test3() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat();
		System.out.println(sdf.format(new Date()));// 格式化日期
		
		System.out.println(sdf.parse("18-8-4 上午1:23"));
	}

	@Test
	public void test2() {
		Date d1 = new Date();
		System.out.println(d1);
		System.out.println(d1.getTime());

		java.sql.Date d2 = new java.sql.Date(1534180297759L);
		System.out.println(d2);
	}

	@Test
	public void test1() {
		System.out.println(System.currentTimeMillis());
		System.out.println(System.currentTimeMillis());
	}
}
