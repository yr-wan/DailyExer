package com.yrwan19.java;

import java.net.URL;

//URL:一个URL对象对应互联网上的一个资源
public class TestURL {
	public static void main(String[] args) throws Exception {
		// 1.创建url对象
		URL url = new URL("https://www.baidu.com/img/superlogo_c4d7df0a003d3db9b65e9ef0fe6da1ec.png");
		/*
		 * public String getProtocol() 获取该URL的协议名
		 * public String getHost()     获取该URL的主机名
		 * public String getPort()     获取该URL的端口号
		 * public String getPath()     获取该URL的文件路径
		 * public String getFile()     获取该URL的文件名
		 * public String getRef()      获取该URL在文件中的相对位置
		 * public String getQuery()    获取该URL的查询名
		 */
		System.out.println(url.getProtocol());
		System.out.println(url.getHost());
		System.out.println(url.getPort());
		System.out.println(url.getPath());
		System.out.println(url.getFile());
		System.out.println(url.getRef());
		System.out.println(url.getQuery());
	}
}
