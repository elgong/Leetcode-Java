package top.elgong.dp;

public class MaximumSubarray53 {


    public int maxSubArray(int[] nums) {
        // input validate
        if(nums==null || nums.length==0){
            return 0;
        }

        int tmpMax = nums[0];
        int res = tmpMax;

        // dp 动态规划
        for(int i=1; i<nums.length; i++){
            int tmp = nums[i]+tmpMax;
            // tmpMax = tmp>=nums[i]?tmp:nums[i];
            tmpMax = Math.max(tmp, nums[i]);
            res = Math.max(tmpMax, res);
            // res = tmpMax>res?tmpMax:res;
        }

        return res;

    }
}
