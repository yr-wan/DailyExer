package com.yrwan12.java;

//�Զ����쳣��
public class MyException extends RuntimeException {
	static final long serialVersionUID = -70348975766939L;

	public MyException() {

	}

	public MyException(String msg) {
		super(msg);
	}
}