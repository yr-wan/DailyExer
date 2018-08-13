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
	private int data = 0;// �������ݣ�ֻ����һ���߳���д�����ݣ������ж���߳�ͬʱ�������ݡ�
	private ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

	public void read() {
		rwl.readLock().lock();// �϶����������߳�ֻ�ɶ�����д
		try {
			System.out.println(Thread.currentThread().getName() + "��ȡ����:" + data);
			Thread.sleep((long) (Math.random() * 1000));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rwl.readLock().unlock();// �ͷŶ�������÷���finnaly����
		}
	}

	public void write(int data) {
		rwl.writeLock().lock();// ��д���������̲߳��ɶ�����д
		this.data = data;
		try {
			System.out.println(Thread.currentThread().getName() + "д������:" + data);
			Thread.sleep((long) (Math.random() * 1000));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rwl.writeLock().unlock();// �ͷ�д������÷���finnaly����
		}
	}
}