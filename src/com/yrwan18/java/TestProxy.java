package com.yrwan18.java;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


/*
 * 动态代理的使用
 */
interface Subject{
	void action();
}

//被代理类
class RealSubject implements Subject{
	@Override
	public void action() {
		System.out.println("这是被代理类 ");
	}
}

interface Subject2 {
	void show();
}
class ObjectImpl implements Subject2 {
	public void show() {
		System.out.println("被代理类的方法");
	}
}

class DynamicProxy implements InvocationHandler {
	Object obj;// 实现了接口的被代理类的对象的声明

	// ①给被代理的对象实例化 ②返回一个代理类的对象
	public Object dynProxy(Object obj) {
		this.obj = obj;
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), this);
	}

	// 当通过代理类的对象发起对被重写的方法的调用时，都会转换为对如下的invoke方法的调用
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object result = method.invoke(obj, args);
		return result;
	}
}

public class TestProxy {
	public static void main(String[] args) {
		// 1.创建一个被代理类的对象
		RealSubject real = new RealSubject();

		// 2.创建一个实现了InvacationHandler接口的类的对象
		DynamicProxy proxy = new DynamicProxy();

		// 3.调用dynProxy()方法，动态地返回一个同样实现了real所在类实现的接口Subject的代理类的对象。
		Subject sub = (Subject) proxy.dynProxy(real);// 此时sub就是代理类的对象

		// 4.转到对InvacationHandler接口的实现类的invoke()方法的调用
		sub.action();
		
		System.out.println("--------------");
		
		ObjectImpl obji = new ObjectImpl();
		Subject2 sub2 = (Subject2)proxy.dynProxy(obji);
		sub2.show();
		
		
	}
}



