package com.yrwan19.java;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;

// URL:统一资源定位符，一个URL对象对应互联网上的一个资源
// 可以通过URL的对象调用其相应的方法，将此资源读取（“下载”）
public class TestURL {
	public static void main(String[] args) throws Exception {
		// 1.可以通过URL的对象调用其相应的方法，将此资源读取（“下载”）
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

		// 如何将服务端的资源读取进来:openStream()
		InputStream is = url.openStream();
		FileOutputStream fos = new FileOutputStream(new File("baidulogo.jpg"));
		byte[] b = new byte[1024];
		int len;
		while ((len = is.read(b)) != -1) {
			fos.write(b, 0, len);
		}
		fos.close();
		is.close();
	}
}
