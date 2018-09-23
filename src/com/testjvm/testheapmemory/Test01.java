package com.testjvm.testheapmemory;

import java.util.ArrayList;

// 运行参数 -Xms20m -Xmx20m -XX:+PrintGCDetails -XX:+HeapDumpOnOutOfMemoryError 
public class Test01 {
	byte[] byteArray = new byte[1 * 1024 * 1024];// 1MB

	public static void main(String[] args) {
		ArrayList<Test01> list = new ArrayList<>();
		try {
			for (int i = 1; i <= 40; i++) {
				list.add(new Test01());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
