package com.yrwan19.java;

import java.net.InetAddress;

/*
 * λ��java.net���£���������IP��ַ��һ���������һ��IP��ַ��
 * 
 */
public class TestInetAddress {
	public static void main(String[] args) throws Exception {
		// ����һ��InetAddress����getByName(String)
		InetAddress inet = InetAddress.getByName("www.baidu.com");
		System.out.println(inet.getHostName());
		System.out.println(inet.getHostAddress());
		//��ȡ����IP:getLocalHost()
		InetAddress inet2 = InetAddress.getLocalHost();
		System.out.println(inet2.getHostName());
		System.out.println(inet2.getHostAddress());
		
	}
}
