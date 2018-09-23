package com.testjvm.testheapmemory;

import org.junit.Test;

public class TestHeapMemory {
	@Test
	public void testHeapMemory(){
		long Xms = Runtime.getRuntime().totalMemory();
		long Xmx = Runtime.getRuntime().maxMemory();
		System.out.println("Xms:" + Xms);
		System.out.println("Xmx:" + Xmx);
	}
}
