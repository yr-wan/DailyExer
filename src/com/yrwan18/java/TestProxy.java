package com.yrwan18.java;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


/*
 * ��̬�����ʹ��
 */
interface Subject{
	void action();
}

//��������
class RealSubject implements Subject{
	@Override
	public void action() {
		System.out.println("���Ǳ������� ");
	}
}

interface Subject2 {
	void show();
}
class ObjectImpl implements Subject2 {
	public void show() {
		System.out.println("��������ķ���");
	}
}

class DynamicProxy implements InvocationHandler {
	Object obj;// ʵ���˽ӿڵı�������Ķ��������

	// �ٸ�������Ķ���ʵ���� �ڷ���һ��������Ķ���
	public Object dynProxy(Object obj) {
		this.obj = obj;
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), this);
	}

	// ��ͨ��������Ķ�����Ա���д�ķ����ĵ���ʱ������ת��Ϊ�����µ�invoke�����ĵ���
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object result = method.invoke(obj, args);
		return result;
	}
}

public class TestProxy {
	public static void main(String[] args) {
		// 1.����һ����������Ķ���
		RealSubject real = new RealSubject();

		// 2.����һ��ʵ����InvacationHandler�ӿڵ���Ķ���
		DynamicProxy proxy = new DynamicProxy();

		// 3.����dynProxy()��������̬�ط���һ��ͬ��ʵ����real������ʵ�ֵĽӿ�Subject�Ĵ�����Ķ���
		Subject sub = (Subject) proxy.dynProxy(real);// ��ʱsub���Ǵ�����Ķ���

		// 4.ת����InvacationHandler�ӿڵ�ʵ�����invoke()�����ĵ���
		sub.action();
		
		System.out.println("--------------");
		
		ObjectImpl obji = new ObjectImpl();
		Subject2 sub2 = (Subject2)proxy.dynProxy(obji);
		sub2.show();
		
		
	}
}



