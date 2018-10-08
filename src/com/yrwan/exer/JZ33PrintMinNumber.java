package com.yrwan.exer;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 33.����һ�����������飬����������������ƴ�������ų�һ��������ӡ��ƴ�ӳ���������������С��һ��
 * ˼·���Ƚ���������ת����String���飬Ȼ��String������������ź�����ַ�������ƴ�ӳ�����
 * �ؼ������ƶ�������򡣻�ʹ�ñȽϺͿ��ŵ�˼�룬��ǰ��������������Ƚϣ���С��ŵ���ǰ�棬����ٵݹ���á�
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
