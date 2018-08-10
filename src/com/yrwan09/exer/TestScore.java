package com.yrwan09.exer;

import java.util.Scanner;
import java.util.Vector;

/*
 * 利用Vector代替数组处理：从键盘读入学生成绩（以负数代表输入结束），找出最高分，并输出学生成绩等级。
 * 提示：数组一旦创建，长度就固定不变，所以在创建数组前就需要知道它的长度。
 * 而向量类java.util.Vector可以根据需要动态伸缩。
 * 创建Vector对象：Vector v=new Vector();
 * 给向量添加元素：v.addElement(obj);//obj必须是对象
 * 取出向量中的元素：Object  obj=v.elementAt(0);
 * 注意第一个元素的下标是0，返回值是Object类型的。
 * 计算向量的长度：v.size();
 * 若与最高分相差  10分内：A等；20分内：B等；
 *           30分内：C等；其它：D等
 */
public class TestScore {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("输入成绩：（以负数代表结束）");
		Vector<Integer> v = new Vector<Integer>();
		int max = 0;
		for (;;) {
			int score = s.nextInt();
			if (score < 0) {
				break;
			}
			if (score >= max) {
				max = score;
			}
			v.addElement(score);// 自动装箱
		}
		s.close();
		// System.out.println("最高分为：" + max);
		for (int i = 0; i < v.size(); i++) {
			Integer score = (Integer) v.elementAt(i);
			char level;
			if (max - score <= 10) {
				level = 'A';
			} else if (max - score <= 20) {
				level = 'B';
			} else if (max - score <= 30) {
				level = 'C';
			} else {
				level = 'D';
			}
			System.out.println("成绩为:" + score + "，等级为:" + level);
		}
	}
}
