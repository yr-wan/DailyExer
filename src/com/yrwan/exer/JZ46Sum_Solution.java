package com.yrwan.exer;
/**
 * 46.��1+2+3+��+n��Ҫ����ʹ�ó˳�����for��while��if��else��switch��case�ȹؼ���
 * �������ж���䣨A?B:C����
 * ˼·�����õݹ��Լ�&&�Ķ�·ԭ������ֵ����ΪBoolean��
 * @author wyran
 *
 */
public class JZ46Sum_Solution {
	public static void main(String[] args) {
		System.out.println(sum_Solution(3));
        System.out.println(sum_Solution2(3));
    }
	// ���õݹ��Լ�&&�Ķ�·ԭ��
	public static int sum_Solution(int n){ 
		int sum = n;
	    @SuppressWarnings("unused")
		boolean result = (n > 0) && ((sum += sum_Solution(n-1)) > 0);
	    return sum;
	}
	// ����try-catchʵ��
	public static int sum_Solution2(int n) {
		try {
			@SuppressWarnings("unused")
			int rt = 1 / n;
			return n + sum_Solution2(n - 1);
		} catch (Exception e) {
		}
		return 0;
	}
}
