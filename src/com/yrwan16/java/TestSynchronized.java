package com.yrwan16.java;

import java.util.concurrent.locks.ReentrantLock;

/*
 * ͬ������顢ͬ��������ͬ����
 */
public class TestSynchronized {
	public static void main(String[] args) {
		Windows4 w = new Windows4();
		Thread t1 = new Thread(w);
		Thread t2 = new Thread(w);
		Thread t3 = new Thread(w);
		t1.setName("����1");
		t2.setName("����2");
		t3.setName("����3");
		t1.start();
		t2.start();
		t3.start();
	}
}

class Windows4 implements Runnable {
	// ͬ������
	int i = 100;
	private final ReentrantLock lock = new ReentrantLock();

	public void run() {
		show();
	}

	@SuppressWarnings("static-access")
	public void show() {
		lock.lock();
		try {
			Thread.currentThread().sleep(10);
			while (i > 0) {
				System.out.println(Thread.currentThread().getName() + ":" + i--);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			lock.unlock();
		}
	}
}

class Windows3 implements Runnable {
	// ͬ������
	int i = 100;

	@SuppressWarnings("static-access")
	public void run() {
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
	// ͬ�������
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