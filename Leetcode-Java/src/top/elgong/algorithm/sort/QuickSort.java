package top.elgong.algorithm.sort;

/**
 * 
 *  快速排序算法
 *  leetcode-912 已测试通过
 */
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class QuickSort {

	public static void main(String[] args) {
		int[] arr= new int[10];
		//random array     
		for(int i=0; i<arr.length; i++) {
			Random rd = new Random();
			arr[i] = rd.nextInt(10); 
		}
		quickSort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));

	}
	
	public static void quickSort(int []arr, int left, int right) {
		
		// 递归出口
		if(left >= right){
			return ;
		}

		// 记录位置
		int BASE = left;
		int RIGHT = right;

		while(left < right){
			/////////////// 先右侧
			while(left < right && arr[right] >= arr[BASE]) right--;
			while(left < right && arr[left] <= arr[BASE]) left++;



			swap(arr, left, right);
		}

		swap(arr, BASE, left);

		quickSort(arr, BASE, left-1);
		quickSort(arr, left+1, RIGHT);
	}
	
	private static void swap(int[] arr, int left, int right) {
		
		int tmp = arr[left];
		arr[left] = arr[right];
		arr[right] = tmp;
	}
}
