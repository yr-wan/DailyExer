package com.yrwan12.java;

//finally相关的问题
public class TestFinally {
	public static void main(String[] args) {
		System.out.println(method());
	}
	@SuppressWarnings("finally")
	public static int method(){
		try {
			System.out.println(10/0);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 2;
		} 
		finally{//一定会执行
			System.out.println("这是finally");
			return 3;//实际情况应避免在finally中出现return
		}
		
	}
}
