package top.elgong.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NextMaxValue496 {

	public static void main(String[] args) {
		
		Solution so = new Solution();
		
		// 测试用例 1
//		int[] nums1 = {4,1,2};
//		int[] nums2 = {1, 3, 4, 2};
		
		// 测试用例2
		int[] nums1 = {};
		int[] nums2 = {};
		
		int [] res = so.nextGreaterElement(nums1, nums2);
		
		System.out.println(Arrays.toString(res));
	}
	
}

class Solution {
	
	
    public Solution() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        // 未使用堆栈。
        // nums1 是 nums2 的子集，所以先把nums2 中所有大于的值记录起来。

        // input validate
        if(nums1 == null || nums1.length == 0){
            return nums1;
        }

        // 记录 nums2 中所有数字的下一个更大值
        Map map = new HashMap<Integer, Integer>();
        for(int i=0; i<nums2.length-1; i++){
            int j = i+1;
            map.put(nums2[i], -1);
            while(j<nums2.length){
                if(nums2[j] > nums2[i]){
                    map.put(nums2[i], nums2[j]);
                    break;
                }
                j++;
            }
        }

        // nums2 最后一个值 一定没更大值
        map.put(nums2[nums2.length-1], -1);

        int[] res = new int[nums1.length];

        // 遍历 nums1， 拿到记录中的最大值
        for(int i=0; i<nums1.length; i++){
            if(map.containsKey(nums1[i])){
                res[i] = (int)map.get(nums1[i]);
            }
        }

        return res;
    }
}
