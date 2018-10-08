package com.yrwan.exer;
/**
 * 32.从1到整数n中1出现的次数
 * 思路：https://blog.csdn.net/yi_afly/article/details/52012593
 * 以百位举例，
 *     若百位上数字为0，百位上可能出现1的次数由更高位决定；
 *     若百位上数字为1，百位上可能出现1的次数不仅受更高位影响还受低位影响；
 *     若百位上数字大于1，则百位上出现1的情况仅由更高位决定
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
	        int a = n / i; // 高位
	        int b = n % i; // 低位
	        count += (a+8) / 10 * i;
	        if(a % 10 == 1){
	            count += b + 1;
	        }
	    }
	    return count;
	}

	public static long CountOne2(long n) {
	    long count = 0; // 1的个数
	    long i = 1;  // 当前位
	    long current = 0,after = 0,before = 0;

	    while((n / i) != 0) {
	        before = n / (i * 10); // 高位
	        current = (n / i) % 10; // 当前位
	        after = n - (n / i) * i;  // 低位

	        if (current == 0)
	            //如果为0,出现1的次数由高位决定,等于高位数字 * 当前位数
	            count = count + before * i;
	        else if(current == 1)
	            //如果为1,出现1的次数由高位和低位决定,高位*当前位+低位+1
	            count = count + before * i + after + 1;
	        else if (current > 1)
	            // 如果大于1,出现1的次数由高位决定,（高位数字+1）* 当前位数
	            count = count + (before + 1) * i;
	        //前移一位
	        i = i * 10;
	    }
	    return count;
	}
}
