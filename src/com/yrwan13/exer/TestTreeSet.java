package com.yrwan13.exer;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

import org.junit.Test;
/*
 * 定义一个Employee类，
 * 该类包含：private成员变量name,age,birthday，其中 birthday 为 MyDate 类的对象；
 * 并为每一个属性定义 getter, setter 方法；
 * 并重写 toString 方法输出 name, age, birthday
 * 
 * MyDate类包含:
 * private成员变量month,day,year；并为每一个属性定义 getter, setter 方法；
 * 
 * 创建该类的 5 个对象，并把这些对象放入 TreeSet 集合中（下一章：TreeSet 需使用泛型来定义）
 * 分别按以下两种方式对集合中的元素进行排序，并遍历输出：
 * 
 * 1). 使Employee 实现 Comparable 接口，并按 name 排序
 * 2). 创建 TreeSet 时传入 Comparator对象，按生日日期的先后排序。
 * 
 * 提示：Employee类是否需要重写equals()方法？MyDate类呢？
 */

public class TestTreeSet{
	@Test
	public void test2() {
		Comparator<Object> com = new Comparator<Object>(){
			@Override
			public int compare(Object o1, Object o2) {
				if(o1 instanceof Employee1 && o2 instanceof Employee1){
					Employee1 e1 = (Employee1)o1;
					Employee1 e2 = (Employee1)o2;
					MyDate b1 = e1.getBirthday();
					MyDate b2 = e2.getBirthday();
					if(b1.getYear().compareTo(b2.getYear()) != 0){
						return b1.getYear().compareTo(b2.getYear());
					}else if(b1.getMonth().compareTo(b2.getMonth()) != 0){
						return b1.getMonth().compareTo(b2.getMonth());
					}else if(b1.getDay().compareTo(b2.getDay()) != 0){
						return b1.getDay().compareTo(b2.getDay());
					}
				}
				return 0;
			}
		};
		TreeSet<Employee1> set = new TreeSet<>(com);
		set.add(new Employee1("AA",21,new MyDate(1996,3,2)));
		set.add(new Employee1("BB",24,new MyDate(1992,9,6)));
		set.add(new Employee1("DD",27,new MyDate(1996,6,3)));
		set.add(new Employee1("EE",22,new MyDate(1992,2,5)));
		set.add(new Employee1("CC",29,new MyDate(1994,8,1)));
		Iterator<Employee1> iterator = set.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		System.out.println("----------------");
	}
	
	
	@Test
	public void test1() {
		TreeSet<Employee> set = new TreeSet<>();
		set.add(new Employee("AA",21,new MyDate(1996,3,2)));
		set.add(new Employee("BB",24,new MyDate(1992,9,6)));
		set.add(new Employee("DD",27,new MyDate(1996,6,3)));
		set.add(new Employee("EE",22,new MyDate(1992,2,5)));
		set.add(new Employee("CC",29,new MyDate(1994,8,1)));
		Iterator<Employee> iterator = set.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		System.out.println("----------------");
	}
}

class Employee1{
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
	
	public Employee1() {
		super();
	}
	public Employee1(String name, int age, MyDate birthday) {
		super();
		this.name = name;
		this.age = age;
		this.birthday = birthday;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", birthday=" + birthday + "]";
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
		Employee1 other = (Employee1) obj;
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
	
}

class Employee implements Comparable<Object>{
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
		return "Employee [name=" + name + ", age=" + age + ", birthday=" + birthday + "]";
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
		if(o instanceof Employee){
			Employee e = (Employee)o;
			return this.getName().compareTo(e.getName());
		}
		return 0;
	}
	
}
class MyDate{
	private Integer year;
	private Integer month;
	private Integer day;
	
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public Integer getMonth() {
		return month;
	}
	public void setMonth(Integer month) {
		this.month = month;
	}
	public Integer getDay() {
		return day;
	}
	public void setDay(Integer day) {
		this.day = day;
	}
	public MyDate() {
		super();
	}
	
	public MyDate(Integer year, Integer month, Integer day) {
		super();
		this.year = year;
		this.month = month;
		this.day = day;
	}
	@Override
	public String toString() {
		return "MyDate [year=" + year + ", month=" + month + ", day=" + day + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((day == null) ? 0 : day.hashCode());
		result = prime * result + ((month == null) ? 0 : month.hashCode());
		result = prime * result + ((year == null) ? 0 : year.hashCode());
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
		if (day == null) {
			if (other.day != null)
				return false;
		} else if (!day.equals(other.day))
			return false;
		if (month == null) {
			if (other.month != null)
				return false;
		} else if (!month.equals(other.month))
			return false;
		if (year == null) {
			if (other.year != null)
				return false;
		} else if (!year.equals(other.year))
			return false;
		return true;
	}
	
}
