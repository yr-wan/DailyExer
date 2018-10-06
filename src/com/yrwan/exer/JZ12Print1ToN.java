package com.yrwan.exer;
/**
 * ��ӡ1������nλ��
 * ˼·�����Ǵ������⣬ʹ���ַ����������ʾ��
 * @author wyran
 *
 */
public class JZ12Print1ToN {
	public static void main(String[] args) {
		print1ToN(10);
	}
	
	/**
	 * ��ӡ1��nλ����ʮ������
	 * @param n ���λ��
	 */
	public static void print1ToN(int n) {
		if (n <= 0) {
			return;
		}
		int[] arr = new int[n];
		printArray(arr, 0);
	}
	
	// �ݹ�����ÿһλ
	public static void printArray(int[] arr, int n) {
		// ÿһλ������
		for (int i = 0; i < 10; i++) {
			if (n != arr.length) {
				arr[n] = i;
				printArray(arr, n+1);
			} else {
				// ���ﳤ�ȣ���ʼ��ӡ
				boolean isBeginning = true;
				for (int j = 0; j < arr.length; j++) {
					// �ж���λ�ǲ���0�������0������
					if (arr[j] == 0 && isBeginning) {
						continue;
					}
					if (arr[j] != 0 && isBeginning) {
						isBeginning = false;
					}
					if (!isBeginning) {
						System.out.print(arr[j]);
					}
				}
				System.out.println();
				return;
			}
	    }
	}

}
