package com.yrwan13.exer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

import org.junit.Test;

/*
 * 1.请从键盘随机输入10个整数保存到List中，并按倒序、从大到小的顺序显示出来
 * 2.请把学生名与考试分数录入到Map中，并按分数显示前三名成绩学员的名字。
 */
public class exer {
	@Test
	public void test2() {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入学生数：");
		int num = sc.nextInt();
		System.out.println("请分别输入学生名与考试分数：");
		TreeMap<String, Integer> map = new TreeMap<String, Integer>();
		for (int i = 0; i < num; i++) {
			String name = sc.next();
			Integer score = sc.nextInt();
			map.put(name, score);
		}
		sc.close();
		System.out.println("输入的结果为：" + map);
		Set<Entry<String, Integer>> entrySet = map.entrySet();
		ArrayList<Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(entrySet);
		Collections.sort(list, new Comparator<Entry<String, Integer>>(){
			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				return o2.getValue() - o1.getValue();
			}
		});
		System.out.println("前三名成绩学员的名字为：");
		for(int i=0; i<3 ;i++){
			System.out.println(list.get(i).getKey());
		}
		
	}

	@Test
	public void test1() {
		System.out.println("请从键盘输入10个整数：");
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			Integer n = sc.nextInt();
			list.add(n);
		}
		sc.close();
		System.out.println("原序为：" + list);
		Collections.reverse(list);
		System.out.println("倒序为：" + list);
		Collections.sort(list);
		Collections.reverse(list);
		System.out.println("从大到小的排序为：" + list);
	}
}
