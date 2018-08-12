package com.yrwan15.java;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import org.junit.Test;

/*
 * ������  ���л� �����л�
 * ObjectInputStream
 * ObjectOutputStream
 */
public class TestOjbectInOutputStream {
	//�����л�����
	@Test
	public void test2() throws ClassNotFoundException, IOException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Ojbtext.txt"));
		Person p1 = (Person)ois.readObject();
		System.out.println(p1);
	}
	//���л�����
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