package com.yrwan.exer;
/**
 * 29.��������һ�����ֳ��ֵĴ����������鳤�ȵ�һ�룬���ҳ��������
 * ˼·�����״γ��ֵ���count+1����֮��������бȽϣ������+1������-1��������У���Ƿ񳬹����ȵ�һ�롣
 * @author wyran
 *
 */
public class JZ29MoreThanHalfNum {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 2, 2, 2, 5, 2, 4 };
		int result = moreThanHalfNum(arr);
		System.out.println(result);
	}
	
	public static int moreThanHalfNum(int[] arr) {
		int max = arr[0];
		int temp = arr[0];
		int count = 1;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] != temp) {
				if (count == 0) {
					temp = arr[i];
					count = 1;
				} else {
					count--;
				}
			} else {
				count++;
			}
			if (count == 1) {
				max = temp;
			}
		}
		return max;
	}
	
	// �����ǻ��ڿ���˼���ʵ�ַ�
	public static int moreThanHalfNum2(int[] arr) {
		if(arr == null){
			return 0;
		}
		int start = 0;
		int end = arr.length - 1;
		int mid = (start + end) / 2;
		int index = partition(arr, start, end);
		while (mid != index) {
			if (mid > index) {
				start = index + 1;
				index = partition(arr, start, end);
			} else {
				end = index - 1;
				index = partition(arr, start, end);
			}
		}
		return arr[index];
	}

	public static int partition(int[] arr, int start, int end) {
		int left = start - 1;
		int right = end;
		int target = arr[end];
		while (left < right) {
			while (left < right && arr[++left] <= target);
			while (left < right && arr[--right] > target);
			int temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
		}
		int temp = arr[left];
		arr[left] = arr[end];
		arr[end] = temp;
		return left;
	}
}
