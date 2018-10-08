package com.yrwan.exer;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 33.输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个
 * 思路：先将整型数组转换成String数组，然后将String数组排序，最后将排好序的字符串数组拼接出来。
 * 关键就是制定排序规则。或使用比较和快排的思想，将前面的数和最后的数比较，若小则放到最前面，最后再递归调用。
 * 
 * @author wyran
 *
 */
public class JZ33PrintMinNumber {
	public static void main(String[] args) {
		int[] arr = {3,32,321};
		System.out.println(printMinNumber(arr));
		
	}
	public static String printMinNumber(int[] arr){
		if(arr == null || arr.length == 0){
			return "";
		}
		String[] str = new String[arr.length];
		for(int i = 0; i< arr.length;i++){
			str[i] = String.valueOf(arr[i]);
		}
		Arrays.sort(str, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				String s1 = o1 + o2;
				String s2 = o2 + o1;
				return -s1.compareTo(s2);
			}
		});
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < arr.length; i++){
	        sb.append(str[i]);
	    }
		return sb.toString();
	}
}
