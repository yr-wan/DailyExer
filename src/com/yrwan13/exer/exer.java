package com.yrwan13.exer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

import org.junit.Test;

/*
 * 1.��Ӽ����������10���������浽List�У��������򡢴Ӵ�С��˳����ʾ����
 * 2.���ѧ�����뿼�Է���¼�뵽Map�У�����������ʾǰ�����ɼ�ѧԱ�����֡�
 */
public class exer {
	@Test
	public void test2() {
		Scanner sc = new Scanner(System.in);
		System.out.println("������ѧ������");
		int num = sc.nextInt();
		System.out.println("��ֱ�����ѧ�����뿼�Է�����");
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < num; i++) {
			String name = sc.next();
			Integer score = sc.nextInt();
			map.put(name, score);
		}
		sc.close();
		System.out.println("����Ľ��Ϊ��" + map);
		Set<Entry<String, Integer>> entrySet = map.entrySet();
		ArrayList<Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(entrySet);
		Collections.sort(list, new Comparator<Entry<String, Integer>>() {
			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				return o2.getValue() - o1.getValue();
			}
		});
		System.out.println("ǰ�����ɼ�ѧԱ������Ϊ��");
		for (int i = 0; i < 3; i++) {
			System.out.println(list.get(i).getKey());
		}

	}

	@Test
	public void test1() {
		System.out.println("��Ӽ�������10��������");
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			Integer n = sc.nextInt();
			list.add(n);
		}
		sc.close();
		System.out.println("ԭ��Ϊ��" + list);
		Collections.reverse(list);
		System.out.println("����Ϊ��" + list);
		Collections.sort(list);
		Collections.reverse(list);
		System.out.println("�Ӵ�С������Ϊ��" + list);
	}
}
