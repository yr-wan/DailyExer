package com.yrwan19.java;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import org.junit.Test;

// UDP编程的实现
public class TestUDP {
	// 发送端
	@Test
	public void send() {
		DatagramSocket ds = null;
		try {
			ds = new DatagramSocket();
			byte[] b = "这是一个要发送的数据".getBytes();
			// 创建一个数据报：每一个数据报不能大于64k，都记录着数据信息， 发送端的IP、端口号，以及要发送到的接收端的IP、端口号。
			DatagramPacket dp = new DatagramPacket(b, 0, b.length, InetAddress.getByName("127.0.0.1"), 9090);
			ds.send(dp);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (ds != null) {
				ds.close();
			}
		}
	}

	//接收端
	@Test
	public void receive() {
		DatagramSocket ds = null;
		try {
			ds = new DatagramSocket(9090);
			byte[] b = new byte[20];
			DatagramPacket dp = new DatagramPacket(b, b.length);
			ds.receive(dp);
			System.out.println(new String(dp.getData(), 0, dp.getLength()));
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (ds != null) {
				ds.close();
			}
		}
	}
}
