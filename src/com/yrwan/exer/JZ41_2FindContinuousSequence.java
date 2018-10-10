package com.yrwan.exer;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 41.2������к�ΪS�������������С������ڰ��մ�С�����˳�����м䰴�տ�ʼ���ִ�С�����˳��
 * ˼·����������ָ�룬�ֱ������Ѱ�Һ�Ϊs�����С�
 * @author wyran
 *
 */
public class JZ41_2FindContinuousSequence {
	public static void main(String[] args) {
		Iterator<ArrayList<Integer>> iterator = findContinuousSequence(15).iterator();
		while (iterator.hasNext()) {
			ArrayList<Integer> aList = iterator.next();
			Iterator<Integer> iterator2 = aList.iterator();
			while (iterator2.hasNext()) {
				System.out.print(iterator2.next() + " ");
			}
			System.out.println();
		}
	}
	
	public static ArrayList<ArrayList<Integer>> findContinuousSequence(int target) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		ArrayList<Integer> list = new ArrayList<>();
		if (target < 3)
			return result;
		int left = 1;
		int right = 2;
		while (left < (target + 1) / 2) {
			int sum = 0;
			for (int i = left; i <= right; i++) {
				sum += i;
			}
			if (sum == target) {
				for (int i = left; i <= right; i++) {
					list.add(i);
				}
				result.add(new ArrayList<>(list));
				list.clear();
				left++;
			} else {
				if (sum > target) {
					left++;
				} else {
					right++;
				}
			}
		}
		return result;
	}
	
	// ˫��forѭ�� o(n2)
	public static ArrayList<ArrayList<Integer>> findContinuousSequence2(int target){
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		for (int i = 1; i <= target / 2; i++) {
			int temp = 0;
			ArrayList<Integer> list = new ArrayList<>();
			for (int j = i; j <= target - temp; j++) {
				temp = temp + j;
				list.add(j);
				if (temp == target) {
					result.add(list);
					break;
				} else if (temp > target) {
					break;
				}
			}
		}
		return result;
	}
}
