package com.yrwan14.exer;

import java.util.Iterator;
import java.util.TreeSet;

import org.junit.Test;

/*
 * 1. ����һ��Employee�࣬
 * ���������private��Ա����name,age,birthday������ birthday Ϊ MyDate ��Ķ���
 * ��Ϊÿһ�����Զ��� getter, setter ������
 * ����д toString ������� name, age, birthday
 * 
 * 
 * MyDate�����:
 * private��Ա����month,day,year����Ϊÿһ�����Զ��� getter, setter ������
 * 
 * ��������� 5 �����󣬲�����Щ������� TreeSet �����У�TreeSet ��ʹ�÷��������壩��
 * �ֱ��������ַ�ʽ�Լ����е�Ԫ�ؽ������򣬲����������
 * 
 * 1). ʹEmployee �̳� Comparable �ӿڣ����� name ����
 * 2). ���� TreeSet ʱ���� Comparator���󣬰��������ڵ��Ⱥ�����
 * 
 */
public class TestEmployee {
	@Test
	public void test() {
		TreeSet<Employee> set = new TreeSet<Employee>();
		set.add(new Employee("AA", 21, new MyDate(1996, 3, 2)));
		set.add(new Employee("BB", 24, new MyDate(1992, 9, 6)));
		set.add(new Employee("DD", 27, new MyDate(1996, 6, 3)));
		set.add(new Employee("EE", 22, new MyDate(1992, 2, 5)));
		set.add(new Employee("CC", 29, new MyDate(1994, 8, 1)));
		Iterator<Employee> i = set.iterator();
		while(i.hasNext()){
			System.out.println(i.next());
		}
	}
}

class Employee implements Comparable<Object> {
	private String name;
	private int age;
	private MyDate birthday;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public MyDate getBirthday() {
		return birthday;
	}

	public void setBirthday(MyDate birthday) {
		this.birthday = birthday;
	}

	public Employee() {
		super();
	}

	public Employee(String name, int age, MyDate birthday) {
		super();
		this.name = name;
		this.age = age;
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "TestEmployee [name=" + name + ", age=" + age + ", birthday=" + birthday + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((birthday == null) ? 0 : birthday.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (age != other.age)
			return false;
		if (birthday == null) {
			if (other.birthday != null)
				return false;
		} else if (!birthday.equals(other.birthday))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public int compareTo(Object o) {
		if (o instanceof Employee) {
			Employee e = (Employee) o;
			return this.getName().compareTo(e.getName());
		}
		return 0;
	}

}

class MyDate {
	private int year;
	private int month;
	private int day;

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public MyDate(int year, int month, int day) {
		super();
		this.year = year;
		this.month = month;
		this.day = day;
	}

	public MyDate() {
		super();
	}

	@Override
	public String toString() {
		return "MyDate [year=" + year + ", month=" + month + ", day=" + day + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + day;
		result = prime * result + month;
		result = prime * result + year;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MyDate other = (MyDate) obj;
		if (day != other.day)
			return false;
		if (month != other.month)
			return false;
		if (year != other.year)
			return false;
		return true;
	}

}