package top.elgong.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumOf3Num {


    /*

    思路： 三指针法  i, m, n
        先排序  O(NlogN)
        i指针从小到大遍历, 遇到>=0时结束
             m 和 n 从i+1 ~ len-1分别趋近中间

        主要问题是重复问题，一个是 i 在遍历过程中的重复， 另一个是m, n 在移动过程中的重复

    time:    NlogN + N^2
    space: O(1)

    */
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {

            List<List<Integer>> res = new ArrayList<>();

            if(nums==null || nums.length < 3){  return res; }

            // 先排序
            Arrays.sort(nums);

            for(int i=0; i<nums.length-2; i++){
                // 大于0 直接结束
                if(nums[i] > 0){
                    break;
                }

                // 解决i 重复
                if(i>=1 && nums[i] == nums[i-1]){
                    continue;
                }

                // 两个指针赋值
                int m = i+1;
                int n = nums.length-1;
                while(m < n){
                    if(nums[n] + nums[m] > -nums[i]){
                        n--;
                    }else if(nums[n] + nums[m] < -nums[i]){
                        m++;
                    }else{
                        ArrayList<Integer> arrList = new ArrayList<>();
                        arrList.add(nums[i]);
                        arrList.add(nums[m]);
                        arrList.add(nums[n]);
                        res.add(arrList);
                        int tmpM = nums[m];
                        int tmpN = nums[n];
                        // 找到不重复的值
                        while(m < n && tmpM == nums[m]) m++;
                        while(m < n && tmpN == nums[n]) n--;
                    }
                }
            }

            return res;

        }
    }
}
