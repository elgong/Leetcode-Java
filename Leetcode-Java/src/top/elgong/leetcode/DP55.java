package top.elgong.leetcode;

/**
 * 
 * @author Misaya
 *  最大连续子序列和 
 *  T55
 *  
 *  思路：连续最大，动态规划
 *  
 *  我是谁？   F(N)max
 *  我从哪里来？   F(N)max = max(N,  F(N-1)max)
 *  
 * 但是，中间会丢掉最大的值，所有需要额外一个res变量记录最大值。
 */
public class DP55 {

	public static void main(String[] args) {
		
		// 输入一组数字， 求连续序列的最大和。答案为6
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		
        int tmpMax = nums[0];
        int res = tmpMax;

        // dp 动态规划
        for(int i=1; i<nums.length; i++){
            int tmp = nums[i]+tmpMax;
            tmpMax = tmp>=nums[i]?tmp:nums[i];
            
            res = tmpMax>res?tmpMax:res;
        }
        
        System.out.println("正确答案  6");
        System.out.println("程序结果 " + res);
        
        
		

	}

}
