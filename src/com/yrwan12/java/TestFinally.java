package com.yrwan12.java;

//finally��ص�����
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
		finally{//һ����ִ��
			System.out.println("����finally");
			return 3;//ʵ�����Ӧ������finally�г���return
		}
		
	}
}
