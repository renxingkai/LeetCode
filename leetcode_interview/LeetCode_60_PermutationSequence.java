package leetcode_interview;

import java.util.ArrayList;

public class LeetCode_60_PermutationSequence {

    public String getPermutation(int n, int k) {
        char[] result = new char[n];
        ArrayList<Integer> nums = new ArrayList<Integer>();
        int[] factorial = new int[n];
        factorial[0] = 1;
        //factorial[i]表示还有多少数字没有确定
        for (int i = 1; i < n; i++) {
            //算阶乘
            factorial[i] = factorial[i - 1] * i;
        }
        //nums为要填的数字
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }
        //第k个数转为index
        k--;
        for (int i = 0; i < n; i++) {
            //结果数组中，从最高位一直填到最后一位
            result[i] = Character.forDigit(nums.remove(k / factorial[n - 1 - i]), 10);
            k = k % factorial[n - 1 - i];
        }
        return new String(result);
    }


}
