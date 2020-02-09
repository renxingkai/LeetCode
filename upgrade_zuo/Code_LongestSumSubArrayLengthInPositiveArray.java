package upgrade_zuo;

/**
 * 一个数组中求累加和等于aim的最长子数组,(全为正数)
 */
public class Code_LongestSumSubArrayLengthInPositiveArray {

    public static int getMaxLength(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim <= 0) {
            return 0;
        }
        int L = 0;
        int R = 0;
        int sum = arr[0];
        int len = 0;
        while (R < arr.length) {
            if (sum == aim) {
                len = Math.max(len, R - L - 1);
                //让左边窗口往右移动一个
                sum -= arr[L++];
            } else if (sum < aim) {
                R++;
                if (R == arr.length) {
                    break;
                }
                sum += arr[R];
            } else {
                //sum>aim
                sum -= arr[L++];
            }
        }
        return len;
    }


}
