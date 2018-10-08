package com.yrwan.exer;

import java.util.Arrays;

/**
 * 24.输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 * 思路：先找到右子树的开始位置，然后分别进行左右子树递归处理。
 * @author wyran
 *
 */
public class JZ24VerifySequenceOfBST {
	public static void main(String[] args) {
		int[] sequence = { 5,7,6,9,11,10,8};
//		int[] sequence = { 7, 4, 6, 5 };
		System.out.println(verifySequenceOfBST(sequence));
	}
	public static boolean verifySequenceOfBST(int[] sequence) {
		if (sequence == null || sequence.length == 0) {
			return false;
		}else{
			return verifySequenceOf(sequence);
		}
	}
	public static boolean verifySequenceOf(int[] sequence) {
		if (sequence.length == 0) {
			return true;
		}
		int rightstart = 0;
		int length = sequence.length;
		for (int i = 0; i < length - 1; i++) {
			if (sequence[i] > sequence[length - 1]) {
				rightstart = i;
				break;
			}
		}
		for (int i = rightstart; i < length - 1; i++) {
			if (sequence[i] <= sequence[length - 1]) {
				return false;
			}
		}
		return verifySequenceOf(Arrays.copyOfRange(sequence, 0, rightstart))
				&& verifySequenceOf(Arrays.copyOfRange(sequence, rightstart, length - 1));
	}
}
