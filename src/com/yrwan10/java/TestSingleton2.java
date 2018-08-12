package com.yrwan10.java;

//�������ģʽ - ����ʽ
public class TestSingleton2 {
	public static void main(String[] args) {

	}
}

class Singleton2 {// �̲߳���ȫ
	private Singleton2() {
	}

	private static Singleton2 s = null;

	@SuppressWarnings("unused")
	private static Singleton2 getInstance() {
		if (s == null) {
			s = new Singleton2();
		}
		return s;
	}
}

class Singleton3 {// �̰߳�ȫ
	private Singleton3() {
	}

	private static Singleton3 s = null;

	@SuppressWarnings("unused")
	private static Singleton3 getInstance() {
		if (s == null) {
			synchronized (Singleton3.class) {
				if (s == null) {
					s = new Singleton3();
				}
			}
		}
		return s;
	}
}