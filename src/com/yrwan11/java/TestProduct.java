package com.yrwan11.java;

//������ �����ڲ���
interface Product {
	int getPrice();
	String getName();
}

public class TestProduct {
	public static void main(String[] args) {
		TestProduct t = new TestProduct();
		// ����һ������һ��   ʵ��Product�ӿڵ���   �Ķ���
		Product phone = new Phone();
		t.showProduct(phone);
		System.out.println("----------------------");
		
		Product p = t.getProduct();
		t.showProduct(p);
		System.out.println("----------------------");
		
		// ������������һ��   ʵ��Product�ӿڵ�������   ����������
		t.showProduct(new Product() {
			public String getName() {
				return "�ֻ�";
			}
			
			public int getPrice() {
				return 5000;
			}
		});
	}

	public Product getProduct() {
		//������һ���ֲ��ڲ���Ķ���
		class Computer implements Product{
			public String getName() {
				return "����";
			}

			public int getPrice() {
				return 7000;
			}
		}
		return new Computer();
		
		//������һ�������ֲ��ڲ���Ķ���
//		return new Product() {
//			public String getName() {
//				return "����";
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
		return "�ֻ�";
	}
	
	public int getPrice() {
		return 5000;
	}
}
