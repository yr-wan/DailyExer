package com.yrwan.exer;

/**
 * 43.��n���������ڵ��ϣ��������ӳ���һ��ĵ���֮��Ϊs,����n,��ӡ��s�����п��ܳ��ֵĸ���
 * ˼·���ݹ�һ�����Զ����µķ�����⣬��ѭ�������Ե����ϣ�ռ�ø��ٵĿռ�͸��ٵ�ʱ�䣬���ܽϺá�
 * ����һ����ά���飬��һ����������6�ֿ��ܣ���һ������Ͷ��Ľ���浽probabilities[0]��
 * �ڶ��ο�ʼ�����ӣ�����һѭ���У����Ǽ���һ�������ӣ�
 * ��ʱ��Ϊn�����ӳ��ִ���Ӧ�õ�����һ��ѭ�������ӵ�����Ϊn-1,n-2,n-3, n-4,n-5��n-6�Ĵ����ܺͣ�
 * �������ǰ���һ������ĵ�n��������Ϊǰһ�������Ӧn-1,n-2,n-3,n-4,n-5��n-6֮��
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
		for (int i = 1; i <= MAX; i++) {// ���������
			probabilityOfDice(n, i, n, 0, times);// ����ÿ�����ܵ��ܺ͵Ĵ���
		}

		// ���
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
 * ��k-1������ʱ��������һ�����ӣ�������ӵĵ���ֻ����Ϊ1��2��3��4��5��6����k�����ӵõ�������Ϊn������У�
 * (k-1,n-1)����k������Ͷ�˵���1 
 * (k-1,n-2)����k������Ͷ�˵���2 ....
 * (k-1,n-6)����k������Ͷ�˵���6 
 * ��k-1�����ӵĻ����ϣ�������һ�����ӳ��ֵ�����Ϊn�Ľ��ֻ����6�������
 * ���ԣ�f(k,n)=f(k-1,n-1)+f(k-1,n-2)+f(k-1,n-3)+f(k-1,n-4)+f(k-1,n-5)+f(k-1,n-6) 
 * ��ʼ������1�����ӣ�f(1,1)=f(1,2)=f(1,3)=f(1,4)=f(1,5)=f(1,6)=1��
 */
	public static void printProbability(int number) {
		if (number < 1)
			return;
		int g_maxValue = 6;
		int[][] probabilities = new int[2][];
		probabilities[0] = new int[g_maxValue * number + 1];
		probabilities[1] = new int[g_maxValue * number + 1];
		int flag = 0;// �����л�����

		// ����һ����������ʱ����6�ֿ��ܣ�ÿ�ֿ��ܳ���һ��
		for (int i = 1; i <= g_maxValue; i++) {
			probabilities[0][i] = 1;
		}

		// �ӵڶ��ο�ʼ�����ӣ������һ�������еĵ�n�����ֱ�ʾ���Ӻ�Ϊn���ֵĴ�����
		for (int k = 2; k <= number; ++k) {
			for (int i = 0; i < k; ++i) {
				// ��k�������ӣ�����СΪk��С��k������ǲ����ܷ�����,����ܷ����Ĵ�������Ϊ0
				probabilities[1 - flag][i] = 0;
			}
			// ��k�������ӣ�����СΪk�����Ϊg_maxValue*k
			for (int i = k; i <= g_maxValue * k; ++i) {
				// ��ʼ������Ϊ����Ҫ�ظ�ʹ�ã���һ�ε�ֵҪ��0
				probabilities[1 - flag][i] = 0;
				for (int j = 1; j <= i && j <= g_maxValue; ++j) {
					probabilities[1 - flag][i] += probabilities[flag][i - j];
				}
			}
			flag = 1 - flag;// ����ǰ������
		}

		double total = Math.pow(g_maxValue, number);
		for (int i = number; i <= g_maxValue * number; i++) {
			double ratio = (double) probabilities[flag][i] / total;
			System.out.println(i + "\t" + ratio);
		}
	}
}
