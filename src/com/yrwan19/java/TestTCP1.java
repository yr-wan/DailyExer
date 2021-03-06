package com.yrwan19.java;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import org.junit.Test;

//客户端发送内容给服务端，服务端将内容打印到控制台上.
public class TestTCP1 {
	//
	@Test
	public void client() {
		Socket socket = null;
		OutputStream os = null;
		try {
			socket = new Socket(InetAddress.getByName("127.0.0.1"), 6789);

			os = socket.getOutputStream();

			os.write("这是客户端传来的消息".getBytes());

			System.out.println("已向服务端发送消息");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (os != null) {
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (socket != null) {
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	// 服务端
	@Test
	public void Server() {
		ServerSocket ss = null;
		Socket s = null;
		InputStream is = null;
		try {
			ss = new ServerSocket(6789);
			s = ss.accept();
			is = s.getInputStream();
			byte[] b = new byte[20];
			int len;
			while ((len = is.read(b)) != -1) {
				System.out.println(new String(b, 0, len));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (s != null) {
				try {
					s.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (ss != null) {
				try {
					ss.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
