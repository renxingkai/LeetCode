package cn.rxk;

/**
 * 直接使用贪心算法，只要可获利就卖出股票
 */
public class LeetCode_122 {

    public static void main(String[] arg) {

    }

    public static int maxProfit(int[] prices) {
        int temp=0;
        int result=0;
        for (int i=1;i<prices.length;i++){
            temp=prices[i]-prices[i-1];
            if (temp>0){
                result+=temp;
            }
        }
        return result;
    }

}
