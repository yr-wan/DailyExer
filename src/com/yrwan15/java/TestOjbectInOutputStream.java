package com.yrwan15.java;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import org.junit.Test;

/*
 * 对象流  序列化 反序列化
 * ObjectInputStream
 * ObjectOutputStream
 */
public class TestOjbectInOutputStream {
	//反序列化过程
	@Test
	public void test2() throws ClassNotFoundException, IOException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Ojbtext.txt"));
		Person p1 = (Person)ois.readObject();
		System.out.println(p1);
		ois.close();
	}
	//序列化过程
	@Test
	public void test1() throws IOException{
		Person p1 = new Person("AA", 23);
		Person p2 = new Person("BB", 22);
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Ojbtext.txt"));
		oos.writeObject(p1);
		oos.flush();
		oos.writeObject(p2);
		oos.close();
	}
}
class Person implements Serializable{
	private static final long serialVersionUID = -4294988515472241236L;
	String name;
	Integer age;
	public Person(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
}