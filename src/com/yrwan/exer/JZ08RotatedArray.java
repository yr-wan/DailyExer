package com.yrwan.exer;

import org.junit.Test;

/**
 * ��һ�������ʼ�����ɸ�Ԫ�ذᵽ�����ĩβ�����ǳ�֮Ϊ�������ת�� 
 * ����һ����������������һ����ת�������ת�������СԪ�ء� 
 * ��������{3,4,5,1,2}Ϊ{1,2,3,4,5}��һ����ת�����������СֵΪ1�� 
 * NOTE������������Ԫ�ض�����0���������СΪ0���뷵��0
 * ˼·�����ö��ַ����ҵ��м������Ȼ�������ߵ�ֵ���бȽϣ�
 * ����������ߵ�����������ߴ�mid��ʼ����С�����ұ�ֵ�������ұߴ�mid��ʼ��
 * ����������ֵ��ȣ���ȡmidǰ��ֵ�н�С������
 * @author wyran
 *
 */
public class JZ08RotatedArray {
	public int rotatedArray(int[] arr) {
		if (arr.length == 0 || arr == null) {
			return -1;
		}
		int left = 0;
		int mid = arr[0];
		int right = arr.length - 1;
		int result = arr[0];
		while(arr[left] >= arr[right]){
			mid = (left + right)/2;
			if (arr[left] == arr[mid] && arr[mid] == arr[right]) {
	            return rotatedArray2(arr);
	        }
			if(arr[left] <= arr[mid]){
				left = mid;
			}else if(arr[right] >= arr[mid]){
				right = mid;
			}
			if(right - left <= 1){
				result = arr[right];
				break;
			}
		}
		return result;
	}

	public int rotatedArray2(int[] arr) {
		if (arr.length == 0 || arr == null) {
			return -1;
		}
		int result = 0;
		if (arr.length > 0) {
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] > arr[i + 1]) {
					result = arr[i + 1];
					break;
				}
			}
		}
		return result;
	}

	@Test
	public void test() {
		System.out.println(rotatedArray(new int[] {1,0,1,1,1}));

	}
}
