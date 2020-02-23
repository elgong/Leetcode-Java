package top.elgong.algorithm.sort;

import java.util.Arrays;
import java.util.Random;

/**
 *  插入排序
 * @author Misaya
 *
 */
public class InsertSort {

	public static void main(String[] args) {
		int[] arr = {1,3,2,4,8,7};
		heapSort(arr);
		System.out.println(Arrays.toString(arr));
	}
	// 不使用一个额外的最大堆, 直接在原数组上进行原地的堆排序
	public static void heapSort(int[] arr) {
		int n = arr.length;
		// 注意，此时我们的堆是从0开始索引的
		// 从(最后一个元素的索引-1)/2开始
		// 最后一个元素的索引 = n-1
		//Heapify
		for (int i = (n - 1 - 1) / 2; i >= 0; i--) {
			heapify(arr, n, i);
		}
		for (int i = n-1; i > 0; i--) {
			swap(arr, 0, i);
			heapify(arr, i, 0);
		}
	}
	// 交换堆中索引为i和j的两个元素
	private static void swap(int[] arr, int i, int j) {
		int t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}

	/**
	 *
	 * @param arr
	 * @param n: 长度
	 * @param k： 头结点
	 */
	private static void heapify(int[] arr, int n, int k) {

		if(n >= k){
			return;
		}

		int left = 2*k+1;
		int right =2*k+2;
		int max = k;
		if(left<n && arr[left]>arr[max]){
			max = left;
		}
		if(right<n && arr[right]>arr[max]){
			max = right;
		}

		if(max != k){
			swap(arr, max, k);
			heapify(arr, n, max);
		}
	}
}
