package com.yrwan12.java;

import java.io.*;

import org.junit.Test;

/*
 * �����쳣Exception�ķ�����ץ��ģ��
 * 1.�ף���ִ�д���ʱ��һ�������쳣���ͻ����쳣�Ĵ��봦����һ����Ӧ���쳣���͵Ķ��󣬲����˶����׳���
 * 		>һ���׳����쳣��Ķ��󣬳������ִֹ��
 *		>���쳣��Ķ����׸������ĵ�����
 * 2.ץ��ץס��һ���׳������쳣��Ķ������ץ����Ϊ�쳣����ķ�ʽ
 * 		��һ��
 * 		try{
 * 			//�����쳣�Ĵ���
 * 		}catch(Exception1 e1){
 * 			//����1
 * 		}catch(Exception2 e2){
 * 			//����2
 * 		}finally{
 * 			//��ִ�еĴ���
 * 		}
 * ע��	1.try�������ı����������ھֲ�����������try{}��䣬�Ͳ��ܱ�����
 *    	2.finally�ǿ�ѡ�ġ�
 * 		3.catch����ڲ��Ƕ��쳣����Ĵ���
 * 			>getMessage();  printStackTrace();
 * 		4.�����ж��catch��䣬try���׳����쳣������������ȥƥ��catch�е��쳣������ͣ�һ������
 * 			 ��ִ��catch�еĴ��롣ִ���꣬���������Ķ���catch���
 *    	5.����쳣�����ˣ���ô���Ĵ������ִ�С�
 *    	6.��catch�ж���쳣������"����"��ϵ���������¶����ԡ�
 *			��catch�ж���쳣������"����"��ϵ���뽫������ڸ�������棬���д������򱨴�
 *		7.finally�д�ŵ���һ���ᱻִ�еĴ��룬����try�С�catch���Ƿ������쳣δ������
 *			�Լ��Ƿ���return��䡣
 *		8.try-catch�ǿ���Ƕ�׵ġ�
 */
public class TestException1 {
	// 1.�����±�Խ���쳣:ArrayIndexOutOfBoundsException
	// catch�Ĳ����ڿ�д���屨���ࣺArrayIndexOutOfBoundsException
	@Test
	public void test1() {
		int[] arr = new int[10];
		try {
			System.out.println(arr[10]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("�����±�Խ���쳣");
		} finally {
			System.out.println("����finally��䣬�ɲ�д����д�˱�ִ��");
		}
	}

	// 2.�����쳣:ArithmeticException
	// catch�Ĳ����ڿ�д���ࣺException
	@Test
	public void test2() {
		int i = 10;
		try {
			System.out.println(i / 0);
		} catch (Exception e) {
			System.out.println("�����쳣");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	// 5.�粻��throws Exception�������ֱ���ʱ�쳣
	// finally�ڴ�ű�ִ�е���䣬����try-catch��Ƕ��
	@Test
	public void test5() {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(new File("test.txt"));
			int b;
			while ((b = fis.read()) != -1) {
				System.out.println((char) b);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
