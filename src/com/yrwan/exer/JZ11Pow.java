package com.yrwan.exer;

import org.junit.Test;

/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。
 * 求base的exponent次方。不得使用库函数，不需要考虑大数问题
 * 思路：不能用==比较两个浮点数是否相等，因为有误差。考虑输入值的多种情况。
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
