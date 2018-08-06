package com.yrwan11.exer;

import java.util.Scanner;

/*
 * 实验题目：
 * 编写工资系统，实现不同类型员工(多态)的按月发放工资。
 * 如果当月出现某个Employee对象的生日，则将该雇员的工资增加100元。
 * 
 * 实验目的：对象、继承、封装、多态、抽象类的组合应用。
 */

// （1）定义一个Employee类，该类包含：
// private成员变量name,number,birthday，其中birthday 为MyDate类的对象；
// abstract方法earnings()；
// toString()方法输出对象的name,number和birthday。
abstract class Employee {
	private String name;
	private int number;
	private MyDate birthday;

	public Employee(String name, int number, MyDate birthday) {
		super();
		this.name = name;
		this.number = number;
		this.birthday = birthday;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public MyDate getBirthday() {
		return birthday;
	}

	public void setBirthday(MyDate birthday) {
		this.birthday = birthday;
	}

	public abstract double earnings();

	public String toString() {
		return "name=" + name + ", number=" + number + ", birthday=" + birthday.toDateString() + ", ";
	}

}

// （2）MyDate类包含:
// private成员变量month,day,year；
// toDateString()方法返回日期对应的字符串：xxxx年xx月xx日
class MyDate {
	private int year;
	private int month;
	private int day;

	public MyDate(int year, int month, int day) {
		super();
		this.year = year;
		this.month = month;
		this.day = day;
	}

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

	public String toDateString() {
		return year + "年" + month + "月" + day + "日";
	}
}

// （3）定义SalariedEmployee类继承Employee类，实现按月计算工资的员工处理。该类包括：
// private成员变量monthlySalary；
// 实现父类的抽象方法earnings(),该方法返回monthlySalary值；
// toString()方法输出员工类型信息及员工的name，number,birthday。
class SalariedEmployee extends Employee {
	private double monthlySalary;

	public SalariedEmployee(String name, int number, MyDate birthday, double monthlySalary) {
		super(name, number, birthday);
		this.monthlySalary = monthlySalary;
	}

	public double earnings() {
		return monthlySalary;
	}

	public String toString() {
		return "SalariedEmployee ["+ super.toString() +"monthlySalary=" + monthlySalary + "]";
	}
}

//（4）参照SalariedEmployee类定义HourlyEmployee类，实现按小时计算工资的员工处理。该类包括：
//private成员变量wage和hour；
//实现父类的抽象方法earnings(),该方法返回wage*hour值；
//toString()方法输出员工类型信息及员工的name，number,birthday。
class HourlyEmployee extends Employee {
	private double wage;
	private double hour;

	public HourlyEmployee(String name, int number, MyDate birthday, double wage, int hour) {
		super(name, number, birthday);
		this.wage = wage;
		this.hour = hour;
	}

	public double earnings() {
		return wage * hour;
	}

	public String toString() {
		return "HourlyEmployee ["+ super.toString() +"wage=" + wage + ", hour=" + hour + "]";
	}
}
//（5）定义PayrollSystem类，创建Employee变量数组并初始化，该数组存放各类雇员对象的引用。
//利用循环结构遍历数组元素，输出各个对象的类型,name,number,birthday,以及该对象生日。
//当键盘输入本月月份值时，如果本月是某个Employee对象的生日，还要输出增加工资信息。
public class PayrollSystem{
	public static void main(String[] args) {
		Employee[] emps = new  Employee[2];
		emps[0] = new SalariedEmployee("AA", 1000, new MyDate(1999, 1, 1), 1000);
		emps[1] = new HourlyEmployee("BB", 1001, new MyDate(1998, 2, 2), 500, 3);
		Scanner c = new Scanner(System.in);
		System.out.println("输入本月月份：");
		int m = c.nextInt();
		c.close();
		for (int i = 0; i < emps.length; i++) {
			if(m == emps[i].getBirthday().getMonth()){
				System.out.println("加100工资");
			}
			System.out.println(emps[i]);
		}
	}
}
