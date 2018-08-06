package com.yrwan11.java;

//匿名内部类
interface Anonymous {
	public double getPrice();

	public String getName();
}

public class AnonymousTest {
	public void test(Anonymous p) {
		System.out.println("购买了一个" + p.getName() + "，花掉了" + p.getPrice());
	}

	public static void main(String[] args) {
		AnonymousTest ta = new AnonymousTest();
		// 调用test方法时，需要传入一个Product参数，
		// 此处传入其匿名实现类的实例
		ta.test(new Anonymous() {
			public double getPrice() {
				return 5678;
			}

			public String getName() {
				return "显卡";
			}
		});
	}
}
