package com.yrwan16.exer;

/*
 * ģ������ȡǮ������
 * 1.����һ��Account��
 * 1����Account���װ���˻���ţ�String������double����������
 * 2��������Ӧ���Ե�getter��setter����
 * 3���ṩ�޲κ������������Ĺ�����
 * 4��ϵͳ�����˺��ж����û��Ƿ�ƥ�䣬���ṩhashCode()��equals()��������д
 * 
 * 2.�ṩһ��ȡǮ���߳���
 * 1���ṩ��Account���account���Ժ�double���ȡ��������
 * 2���ṩ���߳����Ĺ��췽��
 * 3��run()�������ṩȡǮ�Ĳ���
 * 
 * 3.�������д����߳̽��в��ԡ������̰߳�ȫ���⡣
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
				System.out.println(Thread.currentThread().getName()+":"+"ȡǮ��"+amt);
			}else {
				System.out.println("���㣬Ϊ" + accu.getBalance());
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
