package com.yrwan14.exer;

import java.util.Iterator;
import java.util.TreeSet;

import org.junit.Test;

/*
 * 1. 定义一个Employee类，
 * 该类包含：private成员变量name,age,birthday，其中 birthday 为 MyDate 类的对象；
 * 并为每一个属性定义 getter, setter 方法；
 * 并重写 toString 方法输出 name, age, birthday
 * 
 * 
 * MyDate类包含:
 * private成员变量month,day,year；并为每一个属性定义 getter, setter 方法；
 * 
 * 创建该类的 5 个对象，并把这些对象放入 TreeSet 集合中（TreeSet 需使用泛型来定义），
 * 分别按以下两种方式对集合中的元素进行排序，并遍历输出：
 * 
 * 1). 使Employee 继承 Comparable 接口，并按 name 排序
 * 2). 创建 TreeSet 时传入 Comparator对象，按生日日期的先后排序。
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