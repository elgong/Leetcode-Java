package top.elgong.algorithm.search;

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        System.out.println(binarySearch(arr, 6));

    }
    public static int binarySearch(int[] arr, int target){
        // 保证输入数组有序-升序

        int left = 0;
         int right = arr.length;

         while(left <= right){
             int mid = left +(right-left)/2;

             if(arr[mid] == target){
                 return mid;
             }

             if(arr[mid]>target){
                 right = mid - 1;
             }else{
                 left = mid + 1;
             }
         }

         return -1;

    }
}
