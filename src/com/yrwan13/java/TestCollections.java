package com.yrwan13.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

/*
 * 操作Collection 和  Map的Collections工具类：
 */
public class TestCollections {
	
	@SuppressWarnings("unused")
	@Test
	public void testCollections2(){
		/*
		 * Object max(Collection)：根据元素的自然顺序，返回给定集合中的最大元素
		 * Object max(Collection，Comparator)：根据 Comparator 指定的顺序，返回给定集合中的最大元素
		 * Object min(Collection)：根据元素的自然顺序，返回给定集合中的最小元素
		 * Object min(Collection，Comparator)：根据 Comparator 指定的顺序，返回给定集合中的最小元素
		 * int frequency(Collection，Object)：返回指定集合中指定元素的出现次数
		 * void copy(List dest,List src)：将src中的内容复制到dest中
		 * boolean replaceAll(List list，Object oldVal，Object newVal)：使用新值替换 List 对象的所有旧值
		 * 
		 */
		List<String> list = new ArrayList<String>();
		list.add("AA");
		list.add("DD");
		list.add("BB");
		list.add("TT");
		list.add("SS");
		System.out.println(list);
		System.out.println("max:" + Collections.max(list));// 根据元素的自然顺序，返回给定集合中的最大元素
		System.out.println("min:" + Collections.min(list));// 根据元素的自然顺序，返回给定集合中的最小元素
		System.out.println(Collections.frequency(list, "AA"));// 返回指定集合中指定元素的出现次数
		// List<String> list1 = new ArrayList<String>();//错误方式
		List<Object> list1 = Arrays.asList(new Object[list.size()]);
		Collections.copy(list1, list);
		System.out.println(list1);
		
		List<String> list2 = Collections.synchronizedList(list);//list2是线程安全的
	}
	
	@Test
	public void testCollections1(){
		/*
		 * reverse(List)：反转 List 中元素的顺序
		 * shuffle(List)：对 List 集合元素进行随机排序
		 * sort(List)：根据元素的自然顺序对指定 List 集合元素按升序排序
		 * sort(List，Comparator)：根据指定的 Comparator 产生的顺序对 List 集合元素进行排序
		 * swap(List，int， int)：将指定 list 集合中的 i 处元素和 j 处元素进行交换
		 */
		List<String> list = new ArrayList<String>();
		list.add("AA");
		list.add("DD");
		list.add("BB");
		list.add("TT");
		list.add("SS");
		System.out.println(list);
		Collections.reverse(list);// 反转 List 中元素的顺序
		System.out.println(list);
		Collections.shuffle(list);// 对 List 集合元素进行随机排序
		System.out.println(list);
		Collections.sort(list);// 根据元素的自然顺序对指定 List 集合元素按升序排序
		System.out.println(list);
		Collections.swap(list, 0, 1);// 将指定 list 集合中的 i 处元素和 j 处元素进行交换
		System.out.println(list);
	}
}
