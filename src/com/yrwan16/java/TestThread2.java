package com.yrwan16.java;

//1.����һ��ʵ��Runnable������
class SubThread2 implements Runnable {
	static int i = 0;

	// 2.��дrun()������������ʵ���̵߳Ĺ���
	public void run() {
		for (; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + ":" + i);
		}
	}
}

public class TestThread2 {
	public static void main(String[] args) {
		// 3.����Runnableʵ����Ķ���
		SubThread2 st = new SubThread2();
		// 4.����Thread�Ķ��󣬽�֮ǰ�Ķ������βδ���
		Thread t1 = new Thread(st);
		Thread t2 = new Thread(st);
		Thread t3 = new Thread(st);
		t1.setName("�߳�1");
		t2.setName("�߳�2");
		t3.setName("�߳�3");
		// 4.�����̵߳�start()�����������̣߳�������Ӧ��run()����
		
		t1.start();
		t2.start();
		t3.start();

	}
}