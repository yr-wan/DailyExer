package com.yrwan.exer;

// ��ָoffer������4�����ַ����еĿո��滻
public class JZ04ReplaceBlank {
	public static void main(String[] args) {
		StringBuffer str = new StringBuffer();
		str.append("we are happy");
		System.out.println(replaceBlank(str));
	}

	public static String replaceBlank(StringBuffer str) {
		int count = 0;// countΪ�ո���
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ' ') {
				count++;
			}
		}
		int oldLength = str.length() - 1;// oldLengthΪ�滻ǰ��str�±�
		int newLength = str.length() + count * 2;//// �ո�ת����%20���str����
		str.setLength(newLength);
		int indexNew = newLength - 1;// indexNewΪ�ѿո��滻Ϊ%20���str�±�
		while (oldLength > 0 && indexNew > oldLength) {
			if (str.charAt(oldLength) == ' ') {
				str.setCharAt(indexNew--, '0');
				str.setCharAt(indexNew--, '2');
				str.setCharAt(indexNew--, '%');
			} else {
				str.setCharAt(indexNew--, str.charAt(oldLength));
			}
			oldLength--;
		}
		return str.toString();
	}
}
