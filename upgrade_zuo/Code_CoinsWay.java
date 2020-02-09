package upgrade_zuo;

import java.util.HashMap;

public class Code_CoinsWay {

    //--------------------------暴力递归--------------------------------------
    public static int coins1(int[] arr, int aim) {
        if (arr == null | arr.length == 0 || aim < 0) {
            return 0;
        }
        return process1(arr, 0, aim);
    }

    /**
     * @param arr
     * @param index 可以任意自由使用index及其之后任意的钱
     * @param aim   目标钱数
     * @return 方法数
     */
    public static int process1(int[] arr, int index, int aim) {

        int res = 0;
        if (index == arr.length) {
            //到了终止部分，剩的钱数是0，则找到了一种有效的方式 res=1
            //剩的钱数是1，则没有找到一种有效的方式 res=0
            res = aim == 0 ? 1 : 0;
        } else {
            //arr[index] * i已经搞定的钱
            for (int i = 0; arr[index] * i <= aim; i++) {
                //index + 1:index之后的钱,  aim - arr[index] * i:剩下多少钱
                res += process1(arr, index + 1, aim - arr[index] * i);
            }
        }
        return res;
    }
    //--------------------------暴力递归--------------------------------------


    //----------------做一个HashMap缓存，降低暴力递归复杂度-----------------------------------
    //key:"index_aim"
    //value:返回值
    public static HashMap<String, Integer> map = new HashMap<>();

    public static int process_map(int[] arr, int index, int aim) {
        int res = 0;
        if (index == arr.length) {
            //到了终止部分，剩的钱数是0，则找到了一种有效的方式 res=1
            //剩的钱数是1，则没有找到一种有效的方式 res=0
            res = aim == 0 ? 1 : 0;
        } else {
            //arr[index] * i已经搞定的钱
            for (int i = 0; arr[index] * i <= aim; i++) {
                int nextAim = aim - arr[index] * i;
                String key = String.valueOf(index + 1) + "_" + String.valueOf(nextAim);
                if (map.containsKey(key)) {
                    res += map.get(key);
                } else {
                    //index + 1:index之后的钱,  aim - arr[index] * i:剩下多少钱
                    res += process1(arr, index + 1, nextAim);
                }
            }
        }
        //在返回之前，把计算值全部加到map中去
        map.put(String.valueOf(index) + "_" + String.valueOf(aim), res);
        return res;
    }
    //----------------做一个HashMap缓存，降低暴力递归复杂度-----------------------------------


    //--------------------dp--------------------------
    public static int coins4(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        int[][] dp = new int[arr.length][aim + 1];
        for (int i = 0; i < arr.length; i++) {
            dp[i][0] = 1;
        }
        for (int j = 1; arr[0] * j <= aim; j++) {
            dp[0][arr[0] * j] = 1;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j <= aim; j++) {
                dp[i][j] = dp[i - 1][j];
                //左边不越界
                dp[i][j] += j - arr[i] > 0 ? dp[i][j - arr[i]] : 0;
            }
        }
        return dp[arr.length - 1][aim];
    }
    //----------------------------------------------


}
