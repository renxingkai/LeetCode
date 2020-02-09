package upgrade_zuo;

import leetcode.MyAtoi;

import java.util.HashMap;

public class Code_LongestSubarrayLessSumAwesomeSolution {

    public static int maxLengthAwesome(int[] arr, int aim) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int[] min_sums = new int[arr.length];//最小累加和数组
        int[] min_sums_index = new int[arr.length];//取得累加和的右边界
        min_sums[arr.length - 1] = arr[arr.length - 1];
        min_sums_index[arr.length - 1] = arr.length - 1;

        for (int i = arr.length - 2; i >= 0; i--) {
            if (min_sums[i + 1] < 0) {
                //可以累加负数使得自身更小，ends是前一个的位置
                min_sums[i] = min_sums[i + 1] + arr[i];
                min_sums_index[i] = i + 1;
            } else {
                //不能使累加和变得更小，停在自己的位置
                min_sums[i] = arr[i];
                min_sums_index[i] = i;
            }
        }
        //从 start~R-1是要扩展进来的，R停留在下一个要算进来的开头上
        int R = 0;//扩展到的右边界
        int sum = 0;//从start到end内累加和是多少
        int len = 0;
        for (int start = 0; start < arr.length; start++) {
            //start是每一次的开头
            while (R < arr.length && sum + min_sums[R] <= aim) {
                sum += min_sums[R];
                //R是下一个即将要算进来的块开头
                R = min_sums_index[R] + 1;
            }
            //R在start的右边,此时sum已经大于aim,需要减去开头start，
            // 否则窗口内没东西,只减去一个0
            sum -= R > start ? arr[start] : 0;
            //长度即为R-start
            len = Math.max(len, R - start);
            //防止R变不了
            R = Math.max(R, start + 1);
        }
        return len;
    }


}
