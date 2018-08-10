package com.yrwan11.java;

//��Ա�ڲ�����ϰ
public class TestInnerClass {
	public static void main(String[] args) {
		//������̬�ڲ���Ķ���
		Animal.Dog d = new Animal.Dog();
		//�����Ǿ�̬�ڲ���Ķ���
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
	private String name = "����";
	@SuppressWarnings("unused")
	private int age;

	public String getName() {
		return name;
	}

	// ��Ա�ڲ��ࣨ�Ǿ�̬
	class Bird {
		String name = "��";
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
			System.out.println("�����ڲ���Bird");
		}
	}

	// ��Ա�ڲ��ࣨ��̬
	static class Dog {
		String name = "��";
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
			System.out.println("�����ڲ���Dog");
		}
	}

	public void show() {
		System.out.println("�����ⲿ��");
	}
}