package com.yrwan13.java;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

/*
 * Collection�ӿ� ��
 * 		|------List�ӿڣ��洢����ģ������ظ���Ԫ��
 * 				|------ArrayList����Ҫ��ʵ���ࣩ
 * 	 			|------LinkedList����������Ƶ���Ĳ��롢ɾ��������
 * 	 			|------Vector�����ϵ�ʵ���ࡢ�̰߳�ȫ�ģ���Ч��Ҫ����ArrayList��
 * 		|------Set�ӿڣ��洢����ģ������ظ���Ԫ�ء�
 * 				|------HashSet����Ҫ��ʵ���ࣩ
 * 				|------LinkedHashSet(��HashSet�����࣬�����Ǳ�������Ԫ��ʱ���ǰ�����ӽ�ȥ��˳��ʵ�ֵģ�Ƶ���ı��������ٵ���ӡ������������ѡ���)
 * 				|------TreeSet�����԰�����ӽ������е�Ԫ�ص�ָ�����Խ�������
 */
public class TestSet {
	/*
	 * Set����ŵ�Ԫ�������Ҳ����ظ�
	 * ��ӽ�Set�е�Ԫ��������һ��Ҫ��дequals()�� hashCode()��
	 * Ҫ����дequals()�� hashCode()��������һ�¡�
	 * 
	 * 1.�����ԣ�������  != ����ԡ������������ԣ�ָ����Ԫ���ڵײ�洢��λ��������ġ�
	 * 2.�����ظ��ԣ�����Set����ӽ���ͬ��Ԫ�ص�ʱ�򣬺�������������ӽ�ȥ��
	 */
	@Test
	public void testTreeSet2(){
		/*
		 * 4.��������	�ٴ���һ��ʵ��Comparator�ӿڵ�ʵ����Ķ�����ʵ��������дComparator��compare(Object o1,Object o2)����
		 * 			���ڴ�compare()������ָ������Ԫ����������ĸ����Խ�������
		 * 			�۽���ʵ��Comparator�ӿڵ�ʵ����Ķ�����Ϊ�βδ��ݸ�TreeSet�Ĺ�������
		 * 			����TreeSet�����Ԫ�ؼ��ɡ�����ʵ�ִ˽ӿڣ��ᱨ����ʱ�쳣
		 * >Ҫ����д��compare()����compare()������equals()��hashCode()��������һ�¡�
		 */
		TreeSet set = new TreeSet(new Comparator() {
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
		set.add(new Customer("CC", 23));
		set.add(new Customer("MM", 21));
		set.add(new Customer("GG", 25));
		set.add(new Customer("JJ", 24));
		set.add(new Customer("KK", 20));
		set.add(new Customer("DD", 20));

		Iterator iterator = set.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		System.out.println("----------------");
	}
	
	@Test
	public void testTreeSet1(){
		/*
		 * TreeSet:
		 * 1.������ӵ�Ԫ�ر�����ͬһ�����
		 * 2.���԰�����ӽ�SetԪ�ص�ָ����˳�������String����װ��Ĭ�ϴ�С����
		 * 3.�������򣺢���Ȼ����ڶ�������
		 * 4.��Ȼ����	��Ҫ����ӽ�TreeSet�е�Ԫ�����ڵ���implements Comparable�ӿ�
		 * 			����дcompareTo(Object obj)���ڴ˷�����ָ������Ԫ�ص��ĸ����Խ�������
		 * 			����TreeSet�����Ԫ�ؼ��ɡ�����ʵ�ִ˽ӿڣ��ᱨ����ʱ�쳣
		 * 5.��TreeSet�����Ԫ��ʱ�����Ȱ���compareTo()���бȽϣ�һ������0����ʹֻ�и�������ͬ��
		 * 		�������Ի���Ϊ����������ͬ��������һ�������޷���ӽ�����
		 * 
		 * >Ҫ����д��compareTo()����compare()������equals()��hashCode()��������һ�¡�
		 */
		Set set = new TreeSet();
		//��Person��û��ʵ��Comparable�ӿ�ʱ����TreeSet���Peoson��Ķ���ʱ���ᱨ��ClassCastException
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
		 * LinkedHashSetʹ������ά����ӽ����ϵ�˳�򣬵��±���ʱ������ӵ�˳�����
		 * Ƶ���ı��������ٵ���ӡ������������ѡ���
		 */
		Set set = new LinkedHashSet();
		set.add(123);
		set.add(456);
		set.add("AA");
		set.add("BB");
		set.add("BB");//�ظ�Ԫ�ز����
		set.add(null);//Set��Ԫ�ؿ���Ϊnull
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
		set.add("BB");//�ظ�Ԫ�ز����
		set.add(null);//Set��Ԫ�ؿ���Ϊnull
		System.out.println(set.size());
		System.out.println(set);
	}
}
