package com.yrwan.exer;

/*
 * 剑指offer面试题4：将字符串中的空格替换
 * 将一个字符串中的空格替换成“%20”
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy
 * 思路：从后往前复制，数组长度会增加，或使用StringBuilder、StringBuffer类
 */
public class JZ04ReplaceBlank {
	public static String replaceBlank(StringBuffer str) {
		if (str == null) {
			return null;
		}
		int count = 0;// count为空格数
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ' ') {
				count++;
			}
		}
		int oldLength = str.length() - 1;// oldLength为替换前的str下标
		int newLength = str.length() + count * 2;//// 空格转换成%20后的str长度
		str.setLength(newLength);
		int indexNew = newLength - 1;// indexNew为把空格替换为%20后的str下标
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
