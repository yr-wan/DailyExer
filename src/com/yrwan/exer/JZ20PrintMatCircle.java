package com.yrwan.exer;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 20.����һ�����󣬰��մ���������˳ʱ���˳�����δ�ӡ��ÿһ�����֣�
 * ���磬����������¾��� 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 
 * �����δ�ӡ������1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 * ˼·����ֹ�кŴ�����ʼ�кţ���ֹ�кŴ�����ʼ�кţ�
 * @author wyran
 *
 */
public class JZ20PrintMatCircle {
	public static void main(String[] args) {
		int[][] mat = {
				{1,2,3,4},
				{5,6,7,8},
				{9,10,11,12},
				{13,14,15,16}
		};
		ArrayList<Integer> list = printMatCircle(mat);
		Iterator<Integer> iterator = list.iterator();
		while (iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}
	}

	public static ArrayList<Integer> printMatCircle(int[][] mat) {
		if (mat == null) {
			return null;
		}
		ArrayList<Integer> list = new ArrayList<>();
		int start = 0;
		while (mat[0].length > 2 * start && mat.length > 2 * start) {
			printOneCircle(mat, list, start);
			start++;
		}
		return list;
	}

	public static void printOneCircle(int[][] mat, ArrayList<Integer> list, int start) {
		int endX = mat[0].length - 1 - start;
		int endY = mat.length - 1 - start;
		for (int i = start; i <= endX; i++) {
			list.add(mat[start][i]);
		}
		if (start < endY) {
			for (int i = start + 1; i <= endY; i++) {
				list.add(mat[i][endX]);
			}
		}
		if (start < endX && start < endY) {
			for (int i = endX - 1; i >= start; i--) {
				list.add(mat[endY][i]);
			}
		}
		if (start < endX && start < endY - 1) {
			for (int i = endY - 1; i >= start + 1; i--) {
				list.add(mat[i][start]);
			}
		}
	}
}
