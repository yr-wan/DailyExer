package com.yrwan.exer;

import java.util.HashSet;

/**
 * 51.��һ������Ϊn����������������ֶ���0��n-1�ķ�Χ�ڣ��ҳ�����������һ���ظ�������
 * ˼·��ʹ��HashSet
 * @author wyran
 *
 */
public class JZ51Duplicate {
	public static void main(String[] args) {
		int[] arr = { 2, 3, 1, 0, 2, 5, 3 };
		System.out.println(duplicate(arr));
	}

	public static boolean duplicate(int[] arr) {
		if (arr == null || arr.length == 0) {
			return false;
		}
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < arr.length; i++) {
			if (!set.contains(arr[i])) {
				set.add(arr[i]);
			} else {
				return true;
			}
		}
		return false;
	}
}
