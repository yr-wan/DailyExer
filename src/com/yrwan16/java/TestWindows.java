package com.yrwan16.java;

public class TestWindows {
	public static void main(String[] args) {
		Windows w1 = new Windows();
		Windows w2 = new Windows();
		Windows w3 = new Windows();
		w1.setName("һ");
		w2.setName("��");
		w3.setName("��");
		w1.start();
		w2.start();
		w3.start();
	}
}
class Windows extends Thread{
	static int ticket = 100;
	public void run(){
		while(ticket > 0){
			System.out.println(Thread.currentThread().getName() +":"+ticket--);
		}
	}
}