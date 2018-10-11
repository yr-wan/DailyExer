package com.yrwan.exer;
/**
 * 49.��һ���ַ���ת����һ��������Ҫ����ʹ���ַ���ת�������Ŀ⺯���� ��ֵΪ0�����ַ�������һ���Ϸ�����ֵ�򷵻�0
 * ˼·����Ϊ������������������ַ�0��Ӧ48,9��Ӧ57�����ڷ�Χ���򷵻�false��
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
