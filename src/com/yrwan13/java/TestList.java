package com.yrwan13.java;

import java.util.ArrayList;
import java.util.List;

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
public class TestList {

	//ArrayList:List的主要实现
	/* List比Collestion新增加的方法
	 * void add(int index, Object obj):索引位置index处添加obj
	 * boolean addAll(int index, Collection coll):索引位置index处添加coll的所有元素
	 * Object remove(int index):删除指定索引index的元素
	 * Object set(int index, Object obj):修改指定索引index的元素为obj
	 * Object get(int index):获取指定索引index的元素
	 * 
	 * int indexOf(Object obj):返回obj首次出现时的位置，没有返回-1
	 * int lastIndexOf(Object obj):返回obj最后出现时的位置，没有返回-1
	 * List subList(int fromIndex, int toIndex):返回从fromIndex到toIndex左闭右开的子List
	 * 
	 * 增add(Object obj)
	 * 删remove(int index)或remove(Object obj)
	 * 改set(int index, Object obj)
	 * 查get(int index)
	 * 插add(int index, Object obj)
	 * 长度size()
	 */
	@Test
	public void testArrayList2() {
		List list = new ArrayList();
		list.add(123);
		list.add(456);
		list.add("AA");
		list.add("GG");
		list.add("AA");
		System.out.println(list);

		System.out.println(list.indexOf("AA"));
		System.out.println(list.lastIndexOf("AA"));

		List subList = list.subList(1, 3);
		System.out.println(subList);

	}

	@Test
	public void testArrayList1() {
		List list = new ArrayList();
		list.add(123);
		list.add(456);
		list.add("AA");
		list.add("GG");
		System.out.println(list);

		list.add(0, 555);// 索引位置index出添加obj
		System.out.println(list);

		System.out.println(list.get(1));// 获取指定索引index的元素

		list.remove(0);// 删除指定索引index的元素
		System.out.println(list);

		list.set(0, 111);// 修改指定索引index的元素为obj
		System.out.println(list);

		System.out.println("---------------------");
	}
}
