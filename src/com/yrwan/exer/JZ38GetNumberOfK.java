package com.yrwan.exer;

import java.util.HashMap;
/**
 * 38.统计一个数字在排序数组中出现的次数。
 * 思路：利用二分查找+递归思想，进行寻找。当目标值与中间值相等时进行判断
 * @author wyran
 *
 */
public class JZ38GetNumberOfK {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 3, 3, 3, 4, 5 };
		System.out.println(getNumberOfKLeft(arr, 3));
	}
	// 法1有点问题，待修改
	public static int getNumberOfK(int[] arr, int k) {
		return getNumberOfKRight(arr,k)-getNumberOfKLeft(arr,k)+1;
	}

	public static int getNumberOfKLeft(int[] arr, int k) {
		if(arr==null || arr.length == 0){
			return 0;
		}
		int start = 0;
		int end = arr.length-1;
		int mid = 0;
		while(start < end){
			mid = (start+end)/2;
			if(arr[mid]>k){
				end = mid-1;
			}else if(arr[mid]<k){
				start = mid+1;
			}else if(arr[mid] == k && arr[mid-1] ==k){
				end = mid-1;
			}else{
				break;
			}
		}
		return mid;
	}
	public static int getNumberOfKRight(int[] arr, int k) {
		int start = 0;
		int end = arr.length-1;
		int mid = 0;
		while(start < end){
			mid = (start+end)/2;
			if(arr[mid]>k){
				end = mid-1;
			}else if(arr[mid]<k){
				start = mid+1;
			}else if(arr[mid] == k && arr[mid+1] ==k){
				start = mid+1;
			}else{
				break;
			}
		}
		return mid;
	}
	
	
	// 用map实现，O(n)
	public static int getNumberOfK2(int[] arr, int k) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			if (!map.containsKey(arr[i])) {
				map.put(arr[i], 1);
			} else {
				map.put(arr[i], map.get(arr[i]) + 1);
			}
		}
		return map.get(k);
	}
}
