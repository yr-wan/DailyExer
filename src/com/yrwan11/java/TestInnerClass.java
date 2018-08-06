package com.yrwan11.java;

//成员内部类练习
public class TestInnerClass {
	public static void main(String[] args) {
		//创建静态内部类的对象
		Animal.Dog d = new Animal.Dog();
		//创建非静态内部类的对象
		Animal a = new Animal();
		Animal.Bird b = a.new Bird();
		b.info();
		b.showName();
		System.out.println("---------------");
		b.show();
		a.show();
		d.show();
		System.out.println("---------------");
		System.out.println(new Animal().getName());
		System.out.println(new Animal.Dog().getName());
	}
}

class Animal {
	private String name = "动物";
	private int age;

	public String getName() {
		return name;
	}

	// 成员内部类（非静态
	class Bird {
		String name = "鸟";
		int id;

		public Bird() {
			super();
		}

		public void showName() {
			System.out.println(this.name);
			System.out.println(Animal.this.name);
		}

		public void setId(int id) {
			this.id = id;
		}

		public void info() {
			show();
		}
		public void show() {
			System.out.println("这是内部类Bird");
		}
	}

	// 成员内部类（静态
	static class Dog {
		String name = "狗";
		int id;

		public String getName() {
			return name;
		}

		public Dog() {
			super();
		}

		public void setId(int id) {
			this.id = id;
		}

		public void info() {
//			show();
		}
		public void show() {
			System.out.println("这是内部类Dog");
		}
	}

	public void show() {
		System.out.println("这是外部类");
	}
}