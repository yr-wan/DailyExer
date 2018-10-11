package com.yrwan.exer;
/**
 * 49.将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
 * 思路：若为负数，则输出负数，字符0对应48,9对应57，不在范围内则返回false。
 * @author wyran
 *
 */
public class JZ49StrToInt {
	public static void main(String[] args) {
		String str = "12312";
		System.out.println(StrToInt(str));
	}
	public static int StrToInt(String str) {
		if (str == null) {
			return 0;
		}
		int num = 0;
		int k = 1;
		for (int i = str.length() - 1; i >= 0; i--) {
			if(str.charAt(i) == '-'){
				num = -num;
			}else if (str.charAt(i) < '9' || str.charAt(i) > '0') {
				num += (str.charAt(i) - 48) * k;
				k *= 10;
			}else{
				return 0;
			}
		}
		return num;
	}
}
