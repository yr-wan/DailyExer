package com.yrwan.exer;

import java.util.Arrays;

/**
 * 44.�˿��Ƶ�˳��
 * ˼·���������¼�����˿��ƣ����������Ϊ����ģ���0���ֵĴ���>=˳�ӵĲ�ֵ����Ϊ˳�ӡ�
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
		int count = 0; // 0��������0�����С��
		int diff = 0;// ���������
		Arrays.sort(arr);
		
		for (int i = 0; i < arr.length - 1; i++) {
			if(arr[i] == 0){
				count++;
				continue;// ��0ֱ���ж���һ��
			}
			if(arr[i] != arr[i+1]){
				diff += arr[i+1] - arr[i] - 1;
			}else{
				// ���������������
				return false;
			}
		}
		if(diff <= count){
			return true;
		}
		return false;
	}
}
