package com.yrwan.exer;
/**
 * 47.дһ������������������֮�ͣ�Ҫ���ں������ڲ���ʹ��+��-��*��/����������š�
 * ˼·������λ����
 * @author wyran
 *
 */
public class JZ47Add {
	public static int Add(int num1, int num2){
		while (num2 != 0) {
	        // �����λ
	        int temp = num1 ^ num2;
	        // �����λ��1+1��
	        num2 = (num1 & num2) << 1;
	        num1 = temp;
	    }
	    return num1;
	}
}
