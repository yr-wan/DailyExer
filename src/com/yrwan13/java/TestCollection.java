package com.yrwan13.java;

import java.util.Collection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;

import org.junit.Test;

/*
 * 1.存储对象的方式：①数组(基本+引用)  ②集合(引用)
 * 2.数组存储数据的弊端：①长度初始化后不可变；②真正的数组元素个数没有现成的方法可用。
 * 3.集合Collection接口 ：
 * 		|------List接口：存储有序的，可以重复的元素
 * 				|------ArrayList（主要的实现类）
 * 	 			|------LinkedList（更适用于频繁的插入、删除操作）
 * 	 			|------Vector（古老的实现类、线程安全的，但效率要低于ArrayList）
 * 		|------Set接口：存储无序的，不可重复的元素。
 * 				|------HashSet（主要的实现类）
 * 				|------LinkedHashSet(是HashSet的子类，当我们遍历集合元素时，是按照添加进去的顺序实现的；频繁的遍历，较少的添加、插入操作建议选择此)
 * 				|------TreeSet（可以按照添加进集合中的元素的指定属性进行排序）
 * 
 */
public class TestCollection {
	@Test
	public void testCollection3() {
		Collection<Object> coll = new ArrayList<Object>();
		coll.add(123);
		coll.add("AA");
		coll.add("BB");
		Collection<Object> coll1 = Arrays.asList(123, "AA");

		// 10.removeAll(Collection coll):删除当前集合中与形参coll中的共同元素
		coll.removeAll(coll1);
		System.out.println(coll);// [BB]

		// 11.equals(Object obj):判断两集合是否相同，boolean
		System.out.println(coll.equals(coll1));// false

		// 12.hashCode():计算集合中的hash值
		System.out.println(coll.hashCode());

		// 13.toArray():将集合转为数组 Array.asList()是将数组转为集合
		Object[] obj = coll.toArray();
		for (int i = 0; i < obj.length; i++) {
			System.out.println(obj[i]);// [BB]
		}

		// 14.iterator():返回一个Iterator接口实现类的对象，实现集合的遍历
		Iterator<Object> iterator = coll.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());// [BB]
		}

	}

	@Test
	public void testCollection2() {
		Collection<Object> coll = new ArrayList<Object>();
		coll.add(123);
		coll.add("AA");
		coll.add(new Date());
		coll.add("BB");

		// 6.contains(Object obj):判断当前集合中是否包含obj元素，boolean
		// 判断依据：元素所在类的equals()方法
		// 如果存入元素为自定义类的对象，则要求重写该自定义类的equals()方法！
		System.out.println(coll.contains(123));//
		System.out.println(coll.contains(new Date()));// true

		// 7.containAll(Collection coll):判断当前集合中是否包含形参coll中的所有元素
		Collection<Object> coll1 = Arrays.asList(123, "AA", "BB");
		System.out.println(coll.containsAll(coll1));// true

		// 8.retainAll(Collection coll):求当前集合与形参coll中的共同元素，返回给当前集合
		coll.retainAll(coll1);
		System.out.println(coll);// [123, AA, BB]

		// 9.remove(Object obj):删除当前集合中的元素obj，删除成功返回true
		coll.remove(123);
		System.out.println(coll);// [AA， BB]

		System.out.println("-----------------------");
	}

	@Test
	public void testCollection1() {
		Collection<Object> coll = new ArrayList<Object>();

		// 1.size():集合中元素个数
		System.out.println(coll.size());

		// 2.add(Objcet obj):向集合中添加元素
		coll.add(123);
		coll.add("AA");
		coll.add(new Date());
		coll.add("BB");
		System.out.println(coll.size());// 4

		// 3.addAll(Collection coll):将形参coll中的所有元素添加到当前集合中
		Collection<Object> coll1 = Arrays.asList(1, 2, 3);
		coll.addAll(coll1);
		System.out.println(coll.size());// 7

		// 4.isEmpty():判断集合是否为空
		System.out.println(coll.isEmpty());// false

		// 5.clear():清空集合元素
		coll.clear();
		System.out.println(coll.isEmpty());// true

		System.out.println("-----------------------");
	}
}
