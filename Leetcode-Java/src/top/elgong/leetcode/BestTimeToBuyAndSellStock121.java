package top.elgong.leetcode;


public class BestTimeToBuyAndSellStock121 {

    public int maxProfit(int[] prices) {
        if(prices==null || prices.length==0){
            return 0;
        }
        // 当前最低价格
        int min = prices[0];
        // 当前最大利润
        int maxProfit = 0;
        for(int i=1; i<prices.length; i++){
            if(prices[i] <= min){
                min = prices[i];
            }else{
                // 上涨了
                maxProfit = Math.max(maxProfit, prices[i]-min);
            }
        }

        return maxProfit;
    }
}
