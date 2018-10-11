package com.yrwan.exer;

import java.util.ArrayList;

/**
 * 45.ԲȦ�����ʣ�µ����֣�Լɪ�򻷣�
 * ˼·������ѭ������ʵ��
 * @author wyran
 *
 */
public class JZ45LastRemaining {
	public static void main(String[] args) {
		System.out.println(lastRemaining(5, 3));
	}

	public static int lastRemaining(int n, int m) {
		if (n <= 0 || m <= 0) {
			return -1;
		}
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			list.add(i);
		}
		int bt = 0;
		while (list.size() > 1) {
			for (int i = 1; i < m; i++) {
				bt = (bt + 1) % list.size();
			}
//			bt = (bt + m - 1) % list.size(); //һ�����ƹ�ʽ���ɴ��������forѭ��
			list.remove(bt);
		}
		return list.size() == 1 ? list.get(0) : -1;
	}
}
