package com.yrwan13.java;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.junit.Test;

/*
 * Map�ӿڣ�
 * 	|------HashMap:��Ҫ��ʵ���࣬�������null����nullֵ
 * 	|------LinkedHashMap:��HashMap�����࣬���԰�����ӽ�Map��˳��ʵ�ֱ���
 * 	|------TreeMap:��Ҫ����key�������ָ�����Խ�������Ҫ��key��ͬһ����Ķ��󡣶�key����ʹ����Ȼ���� �� ��������
 * 	|------Hashtable:���ϵ�ʵ���࣬�̰߳�ȫ�ģ����������null����nullֵ������ʹ�á�
 * 				|------Properties:���������������ļ�
 */
public class TestMap {
	@Test
	public void testTreeMap2() {
		/*
		 * ��������
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
				throw new RuntimeException("�Ƚ���������");
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
		 * ��Ȼ����
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
		 * LinkedHashMapʹ������ά����ӽ����ϵ�˳�򣬵��±���ʱ������ӵ�˳����� 
		 * Ƶ���ı��������ٵ���ӡ������������ѡ���
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
		 * ��α���HashMap��
		 * key��Set��ţ�value��Collection��ţ�ÿ��key-value����һ��entry����Set��š�
		 * 
		 * Set keySet(): 
		 * Collection values(): 
		 * Set entrySet():
		 */
		Map map = new HashMap();
		map.put("AA", 23);// ��Map�����Ԫ��
		map.put("CC", 13);
		map.put("WW", 64);
		map.put("BB", 24);
		map.put(null, null);
		System.out.println(map);
		// ����key����
		Set keySet = map.keySet();
		Iterator i = keySet.iterator();
		while (i.hasNext()) {
			System.out.println(i.next());
		}
		System.out.println();
		// ����value����
		Collection values = map.values();
		for (Object obj : values) {
			System.out.println(obj);
		}
		System.out.println();
		// ����entry����
		Set entrySet = map.entrySet();
		Iterator j = entrySet.iterator();
		while (j.hasNext()) {
			System.out.println(j.next());
		}
	}

	@Test
	public void testHashMap1() {
		/*
		 * Object put(Object key,Object value):��Map�����Ԫ�� 
		 * void putAll(Map t):��t��ȫ��key-value����ӵ���Map
		 * Object remove(Object key):����keyɾ����key-value�� 
		 * Object get(Object key):��ȡkey��valueֵ
		 * boolean containsKey(Object key):�ж��Ƿ����key��key-value�� 
		 * boolean containsValue(Object value):�ж��Ƿ����value��key-value��
		 * boolean isEmpty():�ж�Map�Ƿ�Ϊ�� 
		 * void clear():���Map 
		 * int size():����Map��entry���� 
		 * boolean equals(Object obj):�ж�Map��obj�Ƿ����
		 * 
		 * HashMap: 
		 * 1.key��Set��ţ�value��Collection��ţ�ÿ��key-value����һ��entry����Set��š�
		 * 2.��equals()�ж��ظ�keyʱ����value���Ǿ�value
		 */
		Map map = new HashMap();
		map.put("AA", 23);// ��Map�����Ԫ��
		map.put("CC", 13);
		map.put("WW", 64);
		map.put("BB", 24);
		map.put(null, null);
		System.out.println(map.size());// ����Map�ĳ���
		System.out.println(map);
		map.remove("BB");// ����keyɾ����key-value��
		System.out.println(map);
		System.out.println(map.get("AA"));// ��ȡkey��valueֵ
		System.out.println(map.isEmpty());// �ж�Map�Ƿ�Ϊ��
		System.out.println(map.containsKey("AA"));// �ж��Ƿ����key��key-value��
		System.out.println("----------------------------------");
	}
}
