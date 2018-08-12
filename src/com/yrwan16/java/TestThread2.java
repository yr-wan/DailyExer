package com.yrwan16.java;

//1.创建一个实现Runnable的子类
class SubThread2 implements Runnable {
	static int i = 0;

	// 2.重写run()方法，方法内实现线程的功能
	public void run() {
		for (; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + ":" + i);
		}
	}
}

public class TestThread2 {
	public static void main(String[] args) {
		// 3.创建Runnable实现类的对象
		SubThread2 st = new SubThread2();
		// 4.创建Thread的对象，将之前的对象当作形参传入
		Thread t1 = new Thread(st);
		Thread t2 = new Thread(st);
		Thread t3 = new Thread(st);
		t1.setName("线程1");
		t2.setName("线程2");
		t3.setName("线程3");
		// 4.调用线程的start()方法，启动线程，调用相应的run()方法
		
		t1.start();
		t2.start();
		t3.start();

	}
}