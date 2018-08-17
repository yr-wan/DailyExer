package com.yrwan19.exer;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import org.junit.Test;

/*
 * 服务端读取图片并发送给客户端，客户端保存图片到本地
 */
public class TestTCP1 {
	@Test
	public void client() {
		Socket s = null;
		InputStream is = null;
		FileOutputStream fos = null;
		try {
			s = new Socket(InetAddress.getByName("127.0.0.1"), 8080);
			is = s.getInputStream();
			fos = new FileOutputStream("imgOutTCP.jpg");
			byte[] b = new byte[1024];
			int len;
			while ((len = is.read(b)) != -1) {
				fos.write(b, 0, len);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
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
		}
	}

	@Test
	public void server() {
		ServerSocket ss = null;
		Socket s = null;
		OutputStream os = null;
		FileInputStream fis = null;
		try {
			ss = new ServerSocket(8080);
			s = ss.accept();
			os = s.getOutputStream();
			fis = new FileInputStream("imgTCP.jpg");
			byte[] b = new byte[1024];
			int len;
			while ((len = fis.read(b)) != -1) {
				os.write(b, 0, len);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (os != null) {
				try {
					os.close();
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
