package com.yrwan16.exer;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class TestRWL {
	public static void main(String[] args) {
		RWL r = new RWL();
		for (int i = 0; i < 3; i++) {
			new Thread() {
				public void run() {
					while (true) {
						r.read();
					}
				}
			}.start();
		}
		for (int i = 0; i < 3; i++) {
			new Thread() {
				public void run() {
					while (true) {
						r.write((int) (Math.random() * 1000));
					}
				}
			}.start();
		}
	}
}

class RWL {
	private int data = 0;// 共享数据，只能有一个线程能写该数据，但可有多个线程同时读该数据。
	private ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

	public void read() {
		rwl.readLock().lock();// 上读锁，其他线程只可读不可写
		try {
			System.out.println(Thread.currentThread().getName() + "读取数据:" + data);
			Thread.sleep((long) (Math.random() * 1000));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rwl.readLock().unlock();// 释放读锁，最好放在finnaly里面
		}
	}

	public void write(int data) {
		rwl.writeLock().lock();// 上写锁，其他线程不可读不可写
		this.data = data;
		try {
			System.out.println(Thread.currentThread().getName() + "写入数据:" + data);
			Thread.sleep((long) (Math.random() * 1000));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rwl.writeLock().unlock();// 释放写锁，最好放在finnaly里面
		}
	}
}