package com.yrwan.exer;
/**
 * 32.��1������n��1���ֵĴ���
 * ˼·��https://blog.csdn.net/yi_afly/article/details/52012593
 * �԰�λ������
 *     ����λ������Ϊ0����λ�Ͽ��ܳ���1�Ĵ����ɸ���λ������
 *     ����λ������Ϊ1����λ�Ͽ��ܳ���1�Ĵ��������ܸ���λӰ�컹�ܵ�λӰ�죻
 *     ����λ�����ִ���1�����λ�ϳ���1��������ɸ���λ����
 * @author wyran
 *
 */
public class JZ32NumberOf1Between1AndN {
	public static int numberOf1Between1AndN(int n){
		
		return 0;
	}
	
	public static void main(String[] args) {
		System.out.println(NumberOf1Between1AndN_Solution(534));
		
//		for(int i = 1 ; i<= 121;i++){
//			System.out.println(i);
//		}
	}
	
	
	public static int NumberOf1Between1AndN_Solution(int n){
	    int count=0;

	    for(int i = 1; i <= n; i *= 10){
	        int a = n / i; // ��λ
	        int b = n % i; // ��λ
	        count += (a+8) / 10 * i;
	        if(a % 10 == 1){
	            count += b + 1;
	        }
	    }
	    return count;
	}

	public static long CountOne2(long n) {
	    long count = 0; // 1�ĸ���
	    long i = 1;  // ��ǰλ
	    long current = 0,after = 0,before = 0;

	    while((n / i) != 0) {
	        before = n / (i * 10); // ��λ
	        current = (n / i) % 10; // ��ǰλ
	        after = n - (n / i) * i;  // ��λ

	        if (current == 0)
	            //���Ϊ0,����1�Ĵ����ɸ�λ����,���ڸ�λ���� * ��ǰλ��
	            count = count + before * i;
	        else if(current == 1)
	            //���Ϊ1,����1�Ĵ����ɸ�λ�͵�λ����,��λ*��ǰλ+��λ+1
	            count = count + before * i + after + 1;
	        else if (current > 1)
	            // �������1,����1�Ĵ����ɸ�λ����,����λ����+1��* ��ǰλ��
	            count = count + (before + 1) * i;
	        //ǰ��һλ
	        i = i * 10;
	    }
	    return count;
	}
}
