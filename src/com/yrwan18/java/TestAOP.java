package com.yrwan18.java;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Human {
	public void show();

	public void fly();
}

class SuperMan implements Human {
	@Override
	public void show() {
		System.out.println("���ǳ���");
	}

	@Override
	public void fly() {
		System.out.println("���ܷ�");
	}
}

class HumanUtil {
	public void method1() {
		System.out.println("=====����һ======");
	}

	public void method2() {
		System.out.println("=====������======");
	}
}

class MyInvocationHandler implements InvocationHandler {
	Object obj;

	public MyInvocationHandler(Object obj) {
		this.obj = obj;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		HumanUtil hu = new HumanUtil();
		hu.method1();
		Object returnVal = method.invoke(obj, args);
		hu.method2();
		return returnVal;
	}
}

class MyProxy {
	public static Object getProxyInstance(Object obj) {
		MyInvocationHandler mih = new MyInvocationHandler(obj);
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), mih);
	}
}

public class TestAOP {
	public static void main(String[] args) {
		SuperMan man = new SuperMan();// ����һ����������Ķ���
		Human h = (Human) MyProxy.getProxyInstance(man);// ����һ��������Ķ���
		h.show();// ͨ��������Ķ��������д�ĳ��󷽷�
		System.out.println();
		h.fly();
		System.out.println();
		RealSubject rs = new RealSubject();
		Subject sj = (Subject) MyProxy.getProxyInstance(rs);
		sj.action();
	}
}
