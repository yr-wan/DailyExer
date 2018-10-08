package com.yrwan.exer;
/**
 * 36.�������е��������֣����ǰ��һ�����ִ��ں�������֣����������������һ������ԡ�
 * ����һ������,�����������е�����Ե�����P
 * ˼·�������ǹ鲢�����ڱȽ�ʱ����ȫ�ֱ���count���м�¼����Եĸ�����
 * ��data[start] >= data[index] ����countֵΪmid+1-start
 * @author wyran
 *
 */
public class JZ36InversePairs {
	public static void main(String[] args) {
		int[] arr = {7,5,6,4};
		System.out.println(inversePairs(arr));
	}
	static int count = 0;
	
	public static int inversePairs(int[] arr){
		if(arr==null)
	        return 0;
	    mergeSort(arr,0,arr.length-1);
	    return count;
	}
	
	private static void mergeSort(int[] data,int start,int end) {
	    int mid = (start + end) / 2;
	    if (start < end) {
	        mergeSort(data, start, mid);
	        mergeSort(data, mid + 1, end);
	        merge(data, start, mid, end);
	    }
	}

	public static void merge(int[] arr,int start,int mid,int end) {
		int temp[] = new int[end - start + 1];
		int num = 0;
		int i = start;
		int j = mid + 1;
		while (i <= mid && j <= end) {
			if (arr[i] < arr[j]) {
				temp[num++] = arr[i++];
			} else {
				temp[num++] = arr[j++];
				count += mid + 1 - i;
			}
		}

		while (i <= mid) {
			temp[num++] = arr[i++];
		}

		while (j <= end) {
			temp[num++] = arr[j++];
		}

		for (int d : temp) {
			arr[start++] = d;
		}
	}

}
