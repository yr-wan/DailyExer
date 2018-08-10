package com.yrwan13.exer;

import java.util.Map;
import java.util.TreeMap;

public class Words {
	public static void main(String[] args) {
		String[] words = { "if", "it", "is", "if", "it", "is", "it", "it", "is" };
		Integer freq;
		Map<String, Integer> m = new TreeMap<String, Integer>();

		for (String a : words) {
			freq = m.get(a);
			if (freq == null) {
				freq = 1;
			} else {
				freq += 1;
			}
			m.put(a, freq);
		}
		System.out.println(m);
	}
}
