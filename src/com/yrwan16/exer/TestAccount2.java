package com.yrwan16.exer;

/*
 * 模拟银行取钱的问题
 * 1.定义一个Account类
 * 1）该Account类封装了账户编号（String）和余额（double）两个属性
 * 2）设置相应属性的getter和setter方法
 * 3）提供无参和有两个参数的构造器
 * 4）系统根据账号判断与用户是否匹配，需提供hashCode()和equals()方法的重写
 * 
 * 2.提供一个取钱的线程类
 * 1）提供了Account类的account属性和double类的取款额的属性
 * 2）提供带线程名的构造方法
 * 3）run()方法中提供取钱的操作
 * 
 * 3.在主类中创建线程进行测试。考虑线程安全问题。
 * 
 */
public class TestAccount2 {
	public static void main(String[] args) {
		Account2 accu = new Account2("1001", 10000);
		Withdraw w1 = new Withdraw("AA", accu, 8000);
		Withdraw w2 = new Withdraw("BB", accu, 3000);
		w1.start();
		w2.start();
		
	}
}
class Withdraw extends Thread{
	private Account2 accu;
	private double amt;
	
	public Withdraw(String name,Account2 accu, double amt) {
		super(name);
		this.accu = accu;
		this.amt = amt;
	}
	@Override
	public void run() {
		synchronized(accu){
			if(accu.getBalance()>=amt){
				accu.setBalance(accu.getBalance() - amt);
				System.out.println(Thread.currentThread().getName()+":"+"取钱："+amt);
			}else {
				System.out.println("余额不足，为" + accu.getBalance());
			}
		}
		
	}
	public void withdraw(Account2 accu, double amt){
		
	}
	
}
class Account2 {
	private String id;
	private double balance;
	public String getId() {
		return id;
	}
	public Account2() {
	}
	public Account2(String id, double balance) {
		this.id = id;
		this.balance = balance;
	}
	public void setId(String id) {
		this.id = id;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(balance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account2 other = (Account2) obj;
		if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Account2 [id=" + id + ", balance=" + balance + "]";
	}
}
