package upgrade_zuo;

import java.util.HashMap;

public class Code_LongestSumSubArrayLength {

    public static int maxLength(int[] arr, int aim) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, -1);
        int len = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            //累加和
            sum += arr[i];
            if (map.containsKey(sum - aim)) {
                len = Math.max(i - map.get(sum - aim), len);
            }
            if (!map.containsKey(sum - aim)) {
                map.put(sum, i);
            }
        }
        return len;

    }


}
