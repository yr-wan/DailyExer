package com.yrwan13.java;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.TreeMap;

import org.junit.Test;

/*
 * Map接口：
 * 	|------HashMap:主要的实现类，可以添加null键，null值
 * 	|------LinkedHashMap:是HashMap的子类，可以按照添加进Map的顺序实现遍历
 * 	|------TreeMap:需要按照key所在类的指定属性进行排序。要求key是同一个类的对象。对key考虑使用自然排序 或 定制排序
 * 	|------Hashtable:古老的实现类，线程安全的，不可以添加null键，null值不建议使用。
 * 				|------Properties:常用来处理属性文件
 */
public class TestMap {
	@Test
	public void properties() throws FileNotFoundException, IOException {
		/*
		 * 使用properties处理属性文件
		 */
		Properties pros = new Properties();
		pros.load(new FileInputStream(new File("test.properties")));
		String user = pros.getProperty("user");
		System.out.println(user);
		String pwd = pros.getProperty("pwd");
		System.out.println(pwd);
	}
	
	@Test
	public void testTreeMap2() {
		/*
		 * 定制排序
		 */
		TreeMap map = new TreeMap(new Comparator() {

			@Override
			public int compare(Object o1, Object o2) {
				if (o1 instanceof Customer && o2 instanceof Customer) {
					Customer c1 = (Customer) o1;
					Customer c2 = (Customer) o2;
					if (c1.getId().compareTo(c2.getId()) == 0) {
						return c1.getName().compareTo(c2.getName());
					} else {
						return c1.getId().compareTo(c2.getId());
					}
				}
				throw new RuntimeException("比较类型有误");
			}
		});
		map.put(new Customer("CC", 23), 23);
		map.put(new Customer("MM", 21), 13);
		map.put(new Customer("GG", 25), 64);
		map.put(new Customer("JJ", 24), 24);
		map.put(new Customer("KK", 20), 26);
		Set keySet = map.keySet();
		for (Object obj : keySet) {
			System.out.println(obj);
		}
	}

	@Test
	public void testTreeMap1() {
		/*
		 * 自然排序
		 */
		TreeMap map = new TreeMap();
		map.put(new Person("CC", 23), 23);
		map.put(new Person("MM", 21), 13);
		map.put(new Person("GG", 25), 64);
		map.put(new Person("JJ", 24), 24);
		map.put(new Person("KK", 20), 26);
		Set keySet = map.keySet();
		for (Object obj : keySet) {
			System.out.println(obj);
		}
	}

	@Test
	public void testLinkedHashMap() {
		/*
		 * LinkedHashMap使用链表维护添加进集合的顺序，导致遍历时按照添加的顺序遍历 
		 * 频繁的遍历，较少的添加、插入操作建议选择此
		 */
		Map map = new LinkedHashMap();
		map.put("AA", 23);
		map.put("CC", 13);
		map.put("WW", 64);
		map.put("BB", 24);
		map.put(null, null);
		System.out.println(map);
		Set keySet = map.keySet();
		for (Object obj : keySet) {
			System.out.println(obj);
		}
	}

	@Test
	public void testHashMap2() {
		/*
		 * 如何遍历HashMap：
		 * key用Set存放，value用Collection存放，每个key-value对是一个entry，用Set存放。
		 * 
		 * Set keySet(): 
		 * Collection values(): 
		 * Set entrySet():
		 */
		Map map = new HashMap();
		map.put("AA", 23);// 向Map中添加元素
		map.put("CC", 13);
		map.put("WW", 64);
		map.put("BB", 24);
		map.put(null, null);
		System.out.println(map);
		// 遍历key集：
		Set keySet = map.keySet();
		Iterator i = keySet.iterator();
		while (i.hasNext()) {
			System.out.println(i.next());
		}
		System.out.println();
		// 遍历value集：
		Collection values = map.values();
		for (Object obj : values) {
			System.out.println(obj);
		}
		System.out.println();
		// 遍历entry集：
		Set entrySet = map.entrySet();
		Iterator j = entrySet.iterator();
		while (j.hasNext()) {
			System.out.println(j.next());
		}
	}

	@Test
	public void testHashMap1() {
		/*
		 * Object put(Object key,Object value):向Map中添加元素 
		 * void putAll(Map t):将t中全部key-value对添加到本Map
		 * Object remove(Object key):按照key删除此key-value对 
		 * Object get(Object key):获取key的value值
		 * boolean containsKey(Object key):判断是否包含key的key-value对 
		 * boolean containsValue(Object value):判断是否包含value的key-value对
		 * boolean isEmpty():判断Map是否为空 
		 * void clear():清空Map 
		 * int size():返回Map的entry个数 
		 * boolean equals(Object obj):判断Map与obj是否相等
		 * 
		 * HashMap: 
		 * 1.key用Set存放，value用Collection存放，每个key-value对是一个entry，用Set存放。
		 * 2.用equals()判断重复key时，新value覆盖旧value
		 */
		Map map = new HashMap();
		map.put("AA", 23);// 向Map中添加元素
		map.put("CC", 13);
		map.put("WW", 64);
		map.put("BB", 24);
		map.put(null, null);
		System.out.println(map.size());// 返回Map的长度
		System.out.println(map);
		map.remove("BB");// 按照key删除此key-value对
		System.out.println(map);
		System.out.println(map.get("AA"));// 获取key的value值
		System.out.println(map.isEmpty());// 判断Map是否为空
		System.out.println(map.containsKey("AA"));// 判断是否包含key的key-value对
		System.out.println("----------------------------------");
	}
}
