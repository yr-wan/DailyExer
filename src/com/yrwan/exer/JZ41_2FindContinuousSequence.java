package com.yrwan.exer;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 41.2输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 * 思路：定义两个指针，分别递增，寻找和为s的序列。
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
	
	// 双层for循环 o(n2)
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
