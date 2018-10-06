package com.yrwan.exer;

import org.junit.Test;

/**
 * ����һ��double���͵ĸ�����base��int���͵�����exponent��
 * ��base��exponent�η�������ʹ�ÿ⺯��������Ҫ���Ǵ�������
 * ˼·��������==�Ƚ������������Ƿ���ȣ���Ϊ������������ֵ�Ķ��������
 * @author wyran
 *
 */
public class JZ11Pow {
	public double power(double base, int e){
		double result = 1.0;
		if(equal(base, 0)){
			return 0.0;
		}
		if(e == 0){
			return 1.0;
		}
		if (e < 0) {
			base = 1/base;
			for(int i = 0; i < -e; i++){
				result *= base; 
			}
		}else{
			for(int i = 0; i < e; i++){
				result *= base; 
			}
		}
		return result;
	}
	
	public boolean equal(double a, double b){
		if(a - b > -0.000001 && a - b <0.000001){
			return true;
		}
		return false;
	}
	
	@Test
	public void test(){
		System.out.println(power(2.0, -2));
	}
}
