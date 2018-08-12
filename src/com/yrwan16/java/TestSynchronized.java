package com.yrwan16.java;

/*
 * 同步代码块
 */
public class TestSynchronized {
	public static void main(String[] args) {
		Windows2 w = new Windows2();
		Thread t1 = new Thread(w);
		Thread t2 = new Thread(w);
		Thread t3 = new Thread(w);
		t1.setName("窗口1");
		t2.setName("窗口2");
		t3.setName("窗口3");
		t1.start();
		t2.start();
		t3.start();
	}
}

class Windows3 implements Runnable {
	// 同步方法
	int i = 100;

	@SuppressWarnings("static-access")
	public void run(){
		show();
	}
	public synchronized void show() {
		try {
			Thread.currentThread().sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		while (i > 0) {
			System.out.println(Thread.currentThread().getName() + ":" + i--);
		}
	}
}

class Windows2 implements Runnable {
	// 同步代码块
	int i = 100;

	@SuppressWarnings("static-access")
	public void run() {
		synchronized (this) {
			try {
				Thread.currentThread().sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			while (i > 0) {
				System.out.println(Thread.currentThread().getName() + ":" + i--);
			}
		}
	}
}

class Windows1 extends Thread {
	static int i = 100;
	static Object lock = new Object();

	@SuppressWarnings("static-access")
	public void run() {
		synchronized (lock) {
			try {
				Thread.currentThread().sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			while (i > 0) {
				System.out.println(Thread.currentThread().getName() + ":" + i--);
			}
		}
	}

}