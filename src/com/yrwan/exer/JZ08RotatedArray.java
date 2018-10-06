package com.yrwan.exer;

import org.junit.Test;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。 
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0
 * 思路：利用二分法，找到中间的数，然后和最左边的值进行比较，
 * 若大于最左边的数，则最左边从mid开始，若小于最右边值，则最右边从mid开始。
 * 若左中右三值相等，则取mid前后值中较小的数。
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
