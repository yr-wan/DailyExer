package com.yrwan13.java;

import java.util.Set;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;
import java.util.Iterator;

import org.junit.Test;

/*
 * Collection接口 ：
 * 		|------List接口：存储有序的，可以重复的元素
 * 				|------ArrayList（主要的实现类）
 * 	 			|------LinkedList（更适用于频繁的插入、删除操作）
 * 	 			|------Vector（古老的实现类、线程安全的，但效率要低于ArrayList）
 * 		|------Set接口：存储无序的，不可重复的元素。
 * 				|------HashSet（主要的实现类）
 * 				|------LinkedHashSet(是HashSet的子类，当我们遍历集合元素时，是按照添加进去的顺序实现的；频繁的遍历，较少的添加、插入操作建议选择此)
 * 				|------TreeSet（可以按照添加进集合中的元素的指定属性进行排序）
 */
public class TestSst {
	/*
	 * Set：存放的元素无序，且不可重复
	 * 添加进Set中的元素所在类一定要重写equals()和 hashCode()。
	 * 要求重写equals()和 hashCode()方法保持一致。
	 * 
	 * 1.无序性：无序性  != 随机性。真正的无序性，指的是元素在底层存储的位置是无序的。
	 * 2.不可重复性：当向Set中添加进相同的元素的时候，后面的这个不能添加进去。
	 */
	@Test
	public void testTreeSet2(){
		Set set = new TreeSet();
		set.add(new Person("CC", 23));
		set.add(new Person("MM", 21));
		set.add(new Person("GG", 25));
		set.add(new Person("JJ", 24));
		set.add(new Person("KK", 20));
		set.add(new Person("DD", 20));
	}
	
	@Test
	public void testTreeSet1(){
		/*
		 * TreeSet:
		 * 1.向其添加的元素必须是同一个类的
		 * 2.可以按照添加进Set元素的指定的顺序遍历，String、包装类默认从小到大
		 * 3.两种排序：①自然排序②定制排序
		 * 4.自然排序：	①要求添加进TreeSet中的元素所在的类implements Comparable接口
		 * 			②重写compareTo(Object obj)，在此方法内指明按照元素的哪个属性进行排序
		 * 			③向TreeSet中添加元素即可。若不实现此接口，会报运行时异常
		 * 5.向TreeSet中添加元素时，首先按照compareTo()进行比较，一但返回0，即使只有该属性相同，
		 * 		但程序仍会认为两个对象相同，导致另一个对象无法添加进来。
		 * 
		 * >要求重写的compareTo()或者compare()方法与equals()和hashCode()方法保持一致。
		 */
		Set set = new TreeSet();
		//当Person类没有实现Comparable接口时，向TreeSet添加Peoson类的对象时，会报错ClassCastException
		set.add(new Person("CC", 23));
		set.add(new Person("MM", 21));
		set.add(new Person("GG", 25));
		set.add(new Person("JJ", 24));
		set.add(new Person("KK", 20));
		set.add(new Person("DD", 20));
		
		Iterator iterator = set.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
		System.out.println("----------------");
	}
	
	@Test
	public void testLinkedHashSet(){
		/*
		 * LinkedHashSet使用链表维护添加进集合的顺序，导致遍历时按照添加的顺序遍历
		 * 频繁的遍历，较少的添加、插入操作建议选择此
		 */
		Set set = new LinkedHashSet();
		set.add(123);
		set.add(456);
		set.add("AA");
		set.add("BB");
		set.add("BB");//重复元素不添加
		set.add(null);//Set的元素可以为null
		System.out.println(set.size());
		Iterator iterator = set.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
		System.out.println("----------------");
	}
	
	@Test
	public void testHashSet() {
		Set set = new HashSet();
		set.add(123);
		set.add(456);
		set.add("AA");
		set.add("BB");
		set.add("BB");//重复元素不添加
		set.add(null);//Set的元素可以为null
		System.out.println(set.size());
		System.out.println(set);
	}
}
