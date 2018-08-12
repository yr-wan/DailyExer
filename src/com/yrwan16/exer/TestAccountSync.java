package com.yrwan16.exer;

/*
 * 有两个储户分别向同一个账户存3000元，每次存1000，存3次。每次存完打印账户余额。
 */
public class TestAccountSync {
	public static void main(String[] args) {
		Account account = new Account();
		Customer c = new Customer(account);
		Thread t1 = new Thread(c);
		Thread t2 = new Thread(c);
		t1.start();
		t2.start();
		
	}
}
class Account{
	int balance;
	public Account(){
		
	}
	public synchronized void deposit(int n){
		balance += n;
		System.out.println(Thread.currentThread().getName()+ ":" + balance);
	}
	
}
class Customer implements Runnable{
	Account account;
	public Customer(Account account){
		this.account = account;
	}
	@Override
	public void run() {
		for (int i = 0; i < 3; i++) {
			account.deposit(1000);
		}
	}
	
}