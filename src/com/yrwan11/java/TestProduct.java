package com.yrwan11.java;
//匿名类 匿名内部类
interface Product {
	int getPrice();
	String getName();
}

public class TestProduct {
	public static void main(String[] args) {
		TestProduct t = new TestProduct();
		// 方法一：创建一个   实现Product接口的类   的对象
		Product phone = new Phone();
		t.showProduct(phone);
		System.out.println("----------------------");
		
		Product p = t.getProduct();
		t.showProduct(p);
		System.out.println("----------------------");
		
		// 方法三：创建一个   实现Product接口的匿名类   的匿名对象
		t.showProduct(new Product() {
			public String getName() {
				return "手机";
			}
			
			public int getPrice() {
				return 5000;
			}
		});
	}

	public Product getProduct() {
		//创建了一个局部内部类的对象
		class Computer implements Product{
			public String getName() {
				return "电脑";
			}

			public int getPrice() {
				return 7000;
			}
		}
		return new Computer();
		
		//创建了一个匿名局部内部类的对象
//		return new Product() {
//			public String getName() {
//				return "电脑";
//			}
//		
//			public int getPrice() {
//				return 7000;
//			}
//
//		};
	}

	public void showProduct(Product p) {
		System.out.println(p.getName());
		System.out.println(p.getPrice());
	}
}

class Phone implements Product{
	public String getName() {
		return "手机";
	}
	
	public int getPrice() {
		return 5000;
	}
}
