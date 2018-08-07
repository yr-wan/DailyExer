package com.yrwan12.exer;

/*
 * ��дӦ�ó���EcmDef.java�����������е�����������Ҫ�������븺�����������������
 * ���������Ͳ�һ��(NumberFormatException)��
 * ȱ�������в���(ArrayIndexOutOfBoundsException)����0(ArithmeticException)
 * �����븺��(EcDef �Զ�����쳣)�����쳣����
 * ��ʾ�� 
 * (1)������(EcmDef)�ж����쳣����(ecm)�������������ܡ�
 * (2)��main()������ʹ���쳣�����������쳣����
 * (3)�ڳ����У��Զ����Ӧ���븺�����쳣��(EcDef)��
 * (4)Integer���static����parseInt(String s)��sת���ɶ�Ӧ��intֵ��
 */
public class EcmDef {
	public static void main(String[] args) {
		try {
			int a1 = Integer.parseInt(args[0]);
			int a2 = Integer.parseInt(args[1]);
			ecm(a1, a2);
		} catch (NumberFormatException e) {
			System.out.println("�������Ͳ�һ��");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("ȱ�������в���");
		} catch (ArithmeticException e) {
			System.out.println("��ĸΪ��");
		} catch (EcDef e) {
			System.out.println(e.getMessage());
		}
	}

	public static void ecm(int i, int j) throws EcDef {
		if(i < 0 || j < 0){
			throw new EcDef("������ֵ���ڸ���");// �ֶ��׳��쳣
		}else{
			System.out.println(i / j);
		}
		
	}

}

class EcDef extends Exception {
	static final long serialVersionUID = -338753124229948L;
	public EcDef() {
	}
	public EcDef(String msg) {
		super(msg);
	}
}