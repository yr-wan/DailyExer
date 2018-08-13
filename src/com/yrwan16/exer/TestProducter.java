package com.yrwan16.exer;

/*
 * ������(Productor)����Ʒ������Ա(Clerk)����������(Customer)�ӵ�Ա��ȡ�߲�Ʒ��
 * ��Աһ��ֻ�ܳ��й̶������Ĳ�Ʒ(����:20���������������ͼ��������Ĳ�Ʒ��
 * ��Ա���������ͣһ�£���������п�λ�Ų�Ʒ����֪ͨ�����߼����������������û�в�Ʒ�ˣ�
 * ��Ա����������ߵ�һ�£���������в�Ʒ����֪ͨ��������ȡ�߲�Ʒ��
 */
public class TestProducter {
	public static void main(String[] args) {
		Clerk c = new Clerk();
		Productor p = new Productor(c);
		Customer1 cu = new Customer1(c);
		Thread t1 = new Thread(p);
		Thread t2 = new Thread(cu);
		t1.start();
		t2.start();
	}
}
class Clerk{
	int product;
	public synchronized void addP() throws InterruptedException{
		if(product>20){
			wait();
		}else{
			product++;
			System.out.println("������" + product);
			notify();
		}
	}
	public synchronized void addB() throws InterruptedException{
		if(product<=0){
			wait();
		}else{
			System.out.println("���ѵ�" + product);
			product--;
			notify();
		}
	}
}
class Productor implements Runnable{
	Clerk c = new Clerk();
	public Productor(Clerk c) {
		this.c = c;
	}
	@SuppressWarnings("static-access")
	public void run() {
		while(true){
			try {
				Thread.currentThread().sleep(50);
				c.addP();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
class Customer1 implements Runnable{
	Clerk c = new Clerk();
	public Customer1(Clerk c) {
		this.c = c;
	}
	@SuppressWarnings("static-access")
	public void run() {
		while(true){
			try {
				Thread.currentThread().sleep(51);
				c.addB();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
