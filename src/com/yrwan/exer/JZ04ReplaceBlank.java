package com.yrwan.exer;

/*
 * ��ָoffer������4�����ַ����еĿո��滻
 * ��һ���ַ����еĿո��滻�ɡ�%20��
 * ���磬���ַ���ΪWe Are Happy.�򾭹��滻֮����ַ���ΪWe%20Are%20Happy
 * ˼·���Ӻ���ǰ���ƣ����鳤�Ȼ����ӣ���ʹ��StringBuilder��StringBuffer��
 */
public class JZ04ReplaceBlank {
	public static String replaceBlank(StringBuffer str) {
		if (str == null) {
			return null;
		}
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

	public static String replaceBlank2(StringBuffer str) {
		if (str == null)
			return null;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ' ') {
				sb.append("%20");
			} else {
				sb.append(str.charAt(i));
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		StringBuffer str = new StringBuffer();
		str.append("we are happy");
		System.out.println(replaceBlank(str));
	}
}
