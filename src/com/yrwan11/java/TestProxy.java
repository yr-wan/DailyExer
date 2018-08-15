package com.yrwan11.java;

//代理模式（静态代理）
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
		System.out.println("代理类创建");
		this.obj = obj;
	}

	public void action() {
		System.out.println("代理类的方法");
		obj.action();
	}
}

class ObjectImpl implements Object {
	public void action() {
		System.out.println("被代理类的方法");
	}
}