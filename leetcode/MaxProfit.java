package leetcode;

public class MaxProfit {

    public int maxProfit(int[] prices) {
        int cheapest=Integer.MAX_VALUE;
        int maxPrice=0;
        for (int i=0;i<prices.length;i++){
            cheapest=Math.min(cheapest,prices[i]);
            //最大卖出时利润
            maxPrice=Math.max(maxPrice,prices[i]-cheapest);
        }
        return maxPrice;
    }

}
