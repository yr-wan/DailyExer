package com.testjvm.testheapmemory;

import java.util.ArrayList;

// ���в��� -Xms20m -Xmx20m -XX:+PrintGCDetails -XX:+HeapDumpOnOutOfMemoryError 
public class TestDump {
	byte[] byteArray = new byte[1 * 1024 * 1024];// 1MB

	public static void main(String[] args) {
		ArrayList<TestDump> list = new ArrayList<>();
		try {
			for (int i = 1; i <= 40; i++) {
				list.add(new TestDump());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
