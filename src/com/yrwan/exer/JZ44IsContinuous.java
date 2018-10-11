package com.yrwan.exer;

import java.util.Arrays;

/**
 * 44.扑克牌的顺子
 * 思路：用数组记录五张扑克牌，将数组调整为有序的，若0出现的次数>=顺子的差值，即为顺子。
 * @author wyran
 *
 */
public class JZ44IsContinuous {
	public static void main(String[] args) {
		int[] arr = {0,0,1,3,4,7};
		System.out.println(isContinious(arr));
	}
	
	public static boolean isContinious(int[] arr){
		if(arr.length == 0|| arr== null){
			return false;
		}
		int count = 0; // 0的数量，0代表大小王
		int diff = 0;// 间隔的数量
		Arrays.sort(arr);
		
		for (int i = 0; i < arr.length - 1; i++) {
			if(arr[i] == 0){
				count++;
				continue;// 是0直接判断下一张
			}
			if(arr[i] != arr[i+1]){
				diff += arr[i+1] - arr[i] - 1;
			}else{
				// 相邻两个数字相等
				return false;
			}
		}
		if(diff <= count){
			return true;
		}
		return false;
	}
}
