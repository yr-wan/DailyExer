package com.yrwan.exer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 40.һ�����������������������֮�⣬���������ֶ����������Ρ���д�����ҳ�������ֻ����һ�ε����֡�
 * ˼·��������ͬ��������Ϊ0��������������õ�һ������Ȼ�����1�ڸ������ұ߳��ֵ�index��
 * Ȼ���ж�ÿ��������index���ǲ���1��
 * @author wyran
 *
 */
public class JZ40FindNumsAppearOnce {
	public static void main(String[] args) {
		int[] arr = {2,4,3,6,3,2,5,5};
		ArrayList<Integer> list = findNumsAppearOnce(arr);
		Iterator<Integer> iterator = list.iterator();
		while(iterator.hasNext()){
			System.out.print(iterator.next() + " ");
		}
	}
	
	
	// ��hashmapʵ��
	public static ArrayList<Integer> findNumsAppearOnce(int[] arr){
		ArrayList<Integer> list = new ArrayList<>();
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < arr.length;i++){
			if(!map.containsKey(arr[i])){
				map.put(arr[i], 1);
			}else{
				map.put(arr[i], map.get(arr[i])+1);
			}
		}
		Set<Entry<Integer, Integer>> set = map.entrySet();
		Iterator<Entry<Integer, Integer>> iterator = set.iterator();
		while(iterator.hasNext()){
			Entry<Integer, Integer> entry = iterator.next();
			if(entry.getValue() == 1){
				list.add(entry.getKey());
			}
		}
		return list;
	}
}
