package com.yrwan.exer;

/**
 * 43.把n个骰子扔在地上，所有骰子朝上一面的点数之和为s,输入n,打印出s的所有可能出现的概率
 * 思路：递归一般是自顶向下的分析求解，而循环则是自底向上，占用更少的空间和更少的时间，性能较好。
 * 定义一个二维数组，第一次掷骰子有6种可能，第一个骰子投完的结果存到probabilities[0]；
 * 第二次开始掷骰子，在下一循环中，我们加上一个新骰子，
 * 此时和为n的骰子出现次数应该等于上一次循环中骰子点数和为n-1,n-2,n-3, n-4,n-5，n-6的次数总和，
 * 所以我们把另一个数组的第n个数字设为前一个数组对应n-1,n-2,n-3,n-4,n-5，n-6之和
 * @author wyran
 *
 */
public class JZ43PrintProbability {
	private static int MAX = 6;

	public static void main(String[] args) {
		int n = 2;
		printProbabilityOfDice(n);// solution 1,use recursion
		System.out.println("============");
		printProbability(n);// solution 2,use DP
	}

	public static void printProbabilityOfDice(int n) {
		if (n < 1) {
			return;
		}
		double total = Math.pow(MAX, n);
		int len = n * MAX - n * 1 + 1;
		int[] times = new int[len];
		for (int i = 1; i <= MAX; i++) {// 最初的骰子
			probabilityOfDice(n, i, n, 0, times);// 计算每个可能的总和的次数
		}

		// 输出
		for (int i = 0; i < len; i++) {
			System.out.println((i + n) + "," + times[i] + "/" + total);
		}

	}

	public static void probabilityOfDice(int n, int curDiceValue, int numOfDices, int curSum, int[] times) {
		if (numOfDices == 1) {
			int sum = curSum + curDiceValue;
			times[sum - n]++;
		} else {
			int sum = curSum + curDiceValue;
			for (int i = 1; i <= MAX; i++) {
				probabilityOfDice(n, i, numOfDices - 1, sum, times);
			}
		}
	}

/*
 * 有k-1个骰子时，再增加一个骰子，这个骰子的点数只可能为1、2、3、4、5或6。那k个骰子得到点数和为n的情况有：
 * (k-1,n-1)：第k个骰子投了点数1 
 * (k-1,n-2)：第k个骰子投了点数2 ....
 * (k-1,n-6)：第k个骰子投了点数6 
 * 在k-1个骰子的基础上，再增加一个骰子出现点数和为n的结果只有这6种情况！
 * 所以：f(k,n)=f(k-1,n-1)+f(k-1,n-2)+f(k-1,n-3)+f(k-1,n-4)+f(k-1,n-5)+f(k-1,n-6) 
 * 初始化：有1个骰子，f(1,1)=f(1,2)=f(1,3)=f(1,4)=f(1,5)=f(1,6)=1。
 */
	public static void printProbability(int number) {
		if (number < 1)
			return;
		int g_maxValue = 6;
		int[][] probabilities = new int[2][];
		probabilities[0] = new int[g_maxValue * number + 1];
		probabilities[1] = new int[g_maxValue * number + 1];
		int flag = 0;// 用于切换数组

		// 当第一次抛掷骰子时，有6种可能，每种可能出现一次
		for (int i = 1; i <= g_maxValue; i++) {
			probabilities[0][i] = 1;
		}

		// 从第二次开始掷骰子，假设第一个数组中的第n个数字表示骰子和为n出现的次数，
		for (int k = 2; k <= number; ++k) {
			for (int i = 0; i < k; ++i) {
				// 第k次掷骰子，和最小为k，小于k的情况是不可能发生的,令不可能发生的次数设置为0
				probabilities[1 - flag][i] = 0;
			}
			// 第k次掷骰子，和最小为k，最大为g_maxValue*k
			for (int i = k; i <= g_maxValue * k; ++i) {
				// 初始化，因为数组要重复使用，上一次的值要清0
				probabilities[1 - flag][i] = 0;
				for (int j = 1; j <= i && j <= g_maxValue; ++j) {
					probabilities[1 - flag][i] += probabilities[flag][i - j];
				}
			}
			flag = 1 - flag;// 交换前后数组
		}

		double total = Math.pow(g_maxValue, number);
		for (int i = number; i <= g_maxValue * number; i++) {
			double ratio = (double) probabilities[flag][i] / total;
			System.out.println(i + "\t" + ratio);
		}
	}
}
