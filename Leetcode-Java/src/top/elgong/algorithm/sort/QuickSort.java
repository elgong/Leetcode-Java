package top.elgong.algorithm.sort;

/**
 * 
 *  快速排序算法
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
		if(left >= right) {
			return;
		}
		
		// 基准值坐标， 一般子组的最左侧
		int base = left;
		
		while(left < right) {
			
			// 基准值在左侧，必须先右侧遍历
			while((left < right) && arr[right] >= arr[base]) {
				right--;
			}
			
			while((left <right) && arr[left] <= arr[base]) {
				left++;
			}
			// 交换 左右
			swap(arr, left, right);
		}
		
		// 基准值 放到指定位置
 		swap(arr, base, right);
 		
 		// 递归
 		quickSort(arr, base, left-1);
 		quickSort(arr, left+1, arr.length-1);
	}
	
	private static void swap(int[] arr, int left, int right) {
		
		int tmp = arr[left];
		arr[left] = arr[right];
		arr[right] = tmp;
	}
}
