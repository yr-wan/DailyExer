package com.yrwan16.exer;

/*
 * 生产者(Productor)将产品交给店员(Clerk)，而消费者(Customer)从店员处取走产品，
 * 店员一次只能持有固定数量的产品(比如:20），如果生产者试图生产更多的产品，
 * 店员会叫生产者停一下，如果店中有空位放产品了再通知生产者继续生产；如果店中没有产品了，
 * 店员会告诉消费者等一下，如果店中有产品了再通知消费者来取走产品。
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
			System.out.println("生产第" + product);
			notify();
		}
	}
	public synchronized void addB() throws InterruptedException{
		if(product<=0){
			wait();
		}else{
			System.out.println("消费第" + product);
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
