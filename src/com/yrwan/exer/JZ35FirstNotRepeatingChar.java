package com.yrwan.exer;

import java.util.HashMap;
/**
 * 35.��һ���ַ���(1<=�ַ�������<=10000��ȫ������ĸ���)���ҵ���һ��ֻ����һ�ε��ַ�
 * ˼·������HashMap�����ַ��ͳ��ִ�����
 * @author wyran
 *
 */
public class JZ35FirstNotRepeatingChar {
	public static void main(String[] args) {
		String str = "abaccdeff";
		System.out.println(firstNotRepeatingChar(str));
	}
	public static char firstNotRepeatingChar(String str){
		if (str == null || str.length() == 0)
	        return 0;
		char[] cs = str.toCharArray();
		HashMap<Character, Integer> map = new HashMap<>();
		for(int i = 0; i < cs.length; i++){
			if(!map.containsKey(cs[i])){
				map.put(cs[i], 1);
			}else{
				map.put(cs[i], map.get(cs[i])+1);
			}
		}
		
		for(int i = 0;i < str.length(); i++){
	        if (map.get(str.charAt(i)) == 1) {
	            return cs[i];
	        }
	    }
	    return 0;
	}
}
