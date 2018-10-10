package com.yrwan.exer;
/**
 * 41.1����һ����������������һ������S���������в�����������ʹ�����ǵĺ�������S��
 * ����ж�����ֵĺ͵���S������������ĳ˻���С�ġ�
 * ˼·����������ָ�룬�ֱ��ǰ��ͺ�����б��������ԽԶ�˻�ԽС�����������ȳ��ֵ��������˻���С
 * @author wyran
 *
 */
public class JZ41_1FindNumberWithSum {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 4, 7, 11, 15 };
		findNumberWithSum(arr, 14);
	}

	public static void findNumberWithSum(int[] arr, int target) {
		if (arr == null || arr.length == 0) {
			return;
		}
		int i = 0;
		int j = arr.length - 1;
		while (i < j) {
			if (arr[i] + arr[j] > target) {
				j--;
			} else if (arr[i] + arr[j] < target) {
				i++;
			} else if (arr[i] + arr[j] == target) {
				System.out.println(arr[i] + " " + arr[j]);
				break;
			}
		}
		System.out.println("can't find");
	}
}
