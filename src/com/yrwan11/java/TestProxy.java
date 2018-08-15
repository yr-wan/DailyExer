package com.yrwan11.java;

//����ģʽ����̬����
public class TestProxy {
	public static void main(String[] args) {
		ObjectImpl obji = new ObjectImpl();
		Object obj = new ProxyObject(obji);
		obj.action();
	}
}

interface Object {
	void action();
}

class ProxyObject implements Object {
	Object obj;

	public ProxyObject(Object obj) {
		System.out.println("�����ഴ��");
		this.obj = obj;
	}

	public void action() {
		System.out.println("������ķ���");
		obj.action();
	}
}

class ObjectImpl implements Object {
	public void action() {
		System.out.println("��������ķ���");
	}
}