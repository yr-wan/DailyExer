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
		System.out.println("我是超人");
	}

	@Override
	public void fly() {
		System.out.println("我能飞");
	}
}

class MyInvocationHandler implements InvocationHandler {
	Object obj;

	public MyInvocationHandler(Object obj) {
		this.obj = obj;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		
		System.out.println("=====方法一======");
		Object returnVal = method.invoke(obj, args);
		System.out.println("=====方法二======");
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
		SuperMan man = new SuperMan();// 创建一个被代理类的对象
		Human h = (Human) MyProxy.getProxyInstance(man);// 返回一个代理类的对象
		h.show();// 通过代理类的对象调用重写的抽象方法
		System.out.println();
		h.fly();
		System.out.println();
		RealSubject rs = new RealSubject();
		Subject sj = (Subject)MyProxy.getProxyInstance(rs);
		sj.action();
	}
}
