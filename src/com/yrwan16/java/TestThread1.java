package com.yrwan16.java;

/*
 * ���߳�
 */

//1.����һ���̳�Thread������
class SubThread extends Thread{
	static int i = 0;
	//2.��дrun()������������ʵ���̵߳Ĺ���
	public void run(){
		for (; i < 100; i++) {
			System.out.println(Thread.currentThread().getName()+ ":" + i);
		}
	}
}
public class TestThread1 {
	public static void main(String[] args) {
		SubThread st1 = new SubThread();
		SubThread st2 = new SubThread();
		SubThread st3 = new SubThread();
		st1.setName("�߳�1");
		st2.setName("�߳�2");
		st3.setName("�߳�3");
		//4.�����̵߳�start()�����������̣߳�������Ӧ��run()����
		st1.start();
		st2.start();
		st3.start();
		
	}
}