package com.yrwan19.java;

import java.net.InetAddress;

/*
 * 位于java.net包下，用来代表IP地址，一个对象代表一个IP地址。
 * 
 */
public class TestInetAddress {
	public static void main(String[] args) throws Exception {
		// 创建一个InetAddress对象getByName(String)
		InetAddress inet = InetAddress.getByName("www.baidu.com");
		System.out.println(inet.getHostName());
		System.out.println(inet.getHostAddress());
		// 获取本机IP:getLocalHost()
		InetAddress inet2 = InetAddress.getLocalHost();
		System.out.println(inet2.getHostName());
		System.out.println(inet2.getHostAddress());

	}
}
