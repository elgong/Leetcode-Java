package top.elgong.algorithm.sort;

/**
 *  归并排序
 */
import java.util.Arrays;
import java.util.Random;

public class MergeSort {

	public static void main(String[] args) {
		int[] arr= new int[10];
		//random array     
		for(int i=0; i<arr.length; i++) {
			Random rd = new Random();
			arr[i] = rd.nextInt(10); 
		}


		mergeSort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void mergeSort(int arr[], int left, int right) {
		
		// 递归出口
		if(left >= right) {
			return ;
		}
		
		int mid = left + (right-left)/2;
		
		// 拆分
		mergeSort(arr, left, mid);
		mergeSort(arr, mid+1, right);
		
		// 合并
		merge(arr, left, right, mid);
	}
	
	private static void merge(int[] arr, int left, int right, int mid ) {
		
		// 待填充数组
		int[] arrTmp = new int[right - left + 1];
		// 数组的索引
	    int	arrTmpIndex = 0;
		
		// 记录原始状态
		// 左右指针
		int rightPoint = mid + 1;
		int leftPoint = left;

		while((leftPoint<=mid) && (rightPoint <= right)) {
			if(arr[leftPoint] <= arr[rightPoint]) {
				arrTmp[arrTmpIndex++] = arr[leftPoint++];
			}else {
				arrTmp[arrTmpIndex++] = arr[rightPoint++];
			}
		}
		
		// 移动剩余的left 到数组
		while(leftPoint <=mid) {
			// System.out.println(arrTmpIndex + "  " + left);
			arrTmp[arrTmpIndex++] = arr[leftPoint++];
		}
		
		// 移动剩余的right 到数组
		while(rightPoint <= right) {
			arrTmp[arrTmpIndex++] = arr[rightPoint++];
		}
		
		// 移动到原数组
		for(int i=0; i<arrTmp.length; i++) {
			arr[left + i] = arrTmp[i];
		}
	}
}
