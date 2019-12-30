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
		int[] arr= new int[10];
		//random array     
		for(int i=0; i<arr.length; i++) {
			Random rd = new Random();
			arr[i] = rd.nextInt(10); 
		}
		
		insertSort(arr);
		System.out.println(Arrays.toString(arr));

	}
	
	
	public static void insertSort(int arr[]) {
		
		for(int i=1; i<arr.length; i++) {
			
			int insertElement = arr[i];
			int j = i-1;
			while(j>0 && (arr[j]>insertElement )) {
				arr[j+1] = arr[j];
				j--;
			}
			// 到达目的地时，也执行了 j--
			arr[j++] = insertElement;
		}
	}
}
