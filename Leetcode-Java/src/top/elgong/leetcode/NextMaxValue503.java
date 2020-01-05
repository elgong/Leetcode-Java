package top.elgong.leetcode;

import java.util.Arrays;

/**
 * 
 * 给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。
 * 数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。
 * 如果不存在，则输出 -1。
 *来源：力扣（LeetCode）
 *链接：https://leetcode-cn.com/problems/next-greater-element-ii

 * @author Misaya
 *
 */
public class NextMaxValue503 {

	public static void main(String[] args) {

		int[] arr = {5,4,3,2,1};
		
		Solution503 so = new Solution503();
		
		int[] res = so.nextGreaterElements(arr);
		
		System.out.println(Arrays.toString(res));

	}

}


// 暴力遍历
class Solution503{
public int[] nextGreaterElements(int[] nums) {
        
        // 输入验证
        if(nums==null || nums.length ==0){
            return nums;
        }
        if(nums.length == 1){
            return new int[]{-1};
        }

        int[] res = new int[nums.length];


        for(int i=0; i<nums.length; i++){
            
            // 保存当前位置
            int logLocation = (i+1)%nums.length;
            while(logLocation != i  ){

                if(nums[logLocation] > nums[i]){
                    res[i] = nums[logLocation];
                    break;
                }else{
                    res[i] = -1;
                }
                logLocation++;
                
                if(logLocation >= nums.length){
                    logLocation = 0;
                }


            }
        }

        return res;
    }
}
