package com.yrwan16.java;

/*
 * 多线程
 */

//1.创建一个继承Thread的子类
class SubThread extends Thread{
	static int i = 0;
	//2.重写run()方法，方法内实现线程的功能
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
		st1.setName("线程1");
		st2.setName("线程2");
		st3.setName("线程3");
		//4.调用线程的start()方法，启动线程，调用相应的run()方法
		st1.start();
		st2.start();
		st3.start();
		
	}
}