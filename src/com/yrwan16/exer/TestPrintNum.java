package com.yrwan16.exer;

/*
 * ʹ�������̴߳�ӡ 1-100. �߳�1, �߳�2 �����ӡ
 */
public class TestPrintNum {
	public static void main(String[] args) {
		Print p = new Print();
		Thread t1 = new Thread(p);
		Thread t2 = new Thread(p);
		t1.setName("A");
		t2.setName("B");
		t1.start();
		t2.start();
	}
}

class Print implements Runnable {
	int i = 1;

	@Override
	public void run() {
		while (true) {
			synchronized (this) {
				notify();
				if (i <= 100) {
					System.out.println(Thread.currentThread().getName() + ":" + i++);
					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				} else {
					break;
				}
			}
		}
	}
}