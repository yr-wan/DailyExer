package com.yrwan19.java;

import java.io.*;
import java.net.*;

import org.junit.Test;

public class TestTCP3 {

	// 从客户端发送文件给服务端，服务端保存到本地。并返回“发送成功”给客户端。并关闭相应的连接。
	// 如下的程序，处理异常时，要使用try-catch-finally 此处仅为了书写方便
	@Test
	public void client() throws Exception {
		Socket s = new Socket(InetAddress.getByName("127.0.0.1"), 8080);
		OutputStream os = s.getOutputStream();
		FileInputStream fis = new FileInputStream("TestTCP.txt");
		byte[] b1 = new byte[20];
		int len1;
		while ((len1 = fis.read(b1)) != -1) {
			os.write(b1, 0, len1);
		}
		s.shutdownOutput();

		InputStream is = s.getInputStream();
		byte[] b2 = new byte[20];
		int len2;
		while ((len2 = is.read(b2)) != -1) {
			System.out.println(new String(b2, 0, len2));
		}
		is.close();
		fis.close();
		os.close();
		s.close();
	}

	@Test
	public void server() throws Exception {
		ServerSocket ss = new ServerSocket(8080);
		Socket s = ss.accept();
		InputStream is = s.getInputStream();
		FileOutputStream fos = new FileOutputStream("TestOutTCP.txt");
		byte[] b = new byte[20];
		int len;
		while ((len = is.read(b)) != -1) {
			fos.write(b, 0, len);
		}

		OutputStream os = s.getOutputStream();
		os.write("我已收到".getBytes());
		os.close();
		fos.close();
		is.close();
		s.close();
		ss.close();
	}
}
