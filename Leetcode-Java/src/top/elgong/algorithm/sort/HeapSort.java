package top.elgong.algorithm.sort;

import java.util.Arrays;
import java.util.Random;

/**
 *  堆排序
 * @author Misaya
 *  leetcode-912 已测试通过
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] arr = {1,3,2,4,8,7};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    // 直接在原数组上进行原地的堆排序
    private static void heapSort(int[] arr) {
        int heapSize = arr.length;

        // 建二茬堆的过程
        // 从最后一个非叶子节点开始,倒着做 heapify.
        // 最后一个非叶子节点 i = (arr.length-2)/2
        for(int i = (heapSize - 2) / 2; i >= 0; i--) {
            heapify_iter(arr, heapSize, i);
        }

        // 堆顶是最值
        // 循环把堆顶移到 数组的末尾
        for (int i = heapSize-1; i > 0; i--) {
            swap(arr, 0, i);
            heapify(arr, i, 0);
        }
    }


    /**
     *
     * @param arr
     * @param heapSize: 堆的大小
     * @param k： root 的索引
     */
    private static void heapify(int[] arr, int heapSize, int k) {
        // 递归结束条件, k超过了堆大小
        if(k >= heapSize){
            return;
        }
        // 左子树，右子树
        int left = 2*k+1;
        int right =2*k+2;
        int max = k;  // 假设当前root 最大
        // 找到root, root.left,  root.right 中最大的
        if(left<heapSize && arr[left]>arr[max]){
            max = left;
        }
        if(right<heapSize && arr[right]>arr[max]){
            max = right;
        }

        // 将最大值移到root, 继续递归
        if(max != k){
            swap(arr, max, k);
            heapify(arr, heapSize, max);
        }
    }

    public static void heapify_iter(int[] array, int heapSize, int index) {
        int left, right, iMax;
        while (true) {
            left = 2 * index + 1;// 左孩子的下标（如果存在的话）
            right = 2 * index + 2;// 左孩子的下标（如果存在的话）
            iMax = index;// 寻找3个节点中最大值节点的下标

            if (left < heapSize && array[left] > array[index])
                iMax = left;
            if (right < heapSize && array[right] > array[iMax])
                iMax = right;

            if (iMax != index) {
                swap(array, iMax, index);
                index = iMax;
            } else
                break;
        }
    }


    /**
     *   交换堆中索引为i和j的两个元素
     * @param arr
     * @param i
     * @param j
     */
    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
