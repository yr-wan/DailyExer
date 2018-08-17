package com.yrwan19.java;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import org.junit.Test;

// UDP��̵�ʵ��
public class TestUDP {
	// ���Ͷ�
	@Test
	public void send() {
		DatagramSocket ds = null;
		try {
			ds = new DatagramSocket();
			byte[] b = "����һ��Ҫ���͵�����".getBytes();
			// ����һ�����ݱ���ÿһ�����ݱ����ܴ���64k������¼��������Ϣ�� ���Ͷ˵�IP���˿ںţ��Լ�Ҫ���͵��Ľ��ն˵�IP���˿ںš�
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

	//���ն�
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
