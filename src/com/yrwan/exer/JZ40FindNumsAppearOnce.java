package com.yrwan.exer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 40.一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 * 思路：两个相同的数异或后为0，将所有数异或后得到一个数，然后求得1在该数最右边出现的index，
 * 然后判断每个数右移index后是不是1。
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
	
	
	// 用hashmap实现
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
