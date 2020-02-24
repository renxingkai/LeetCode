package leetcode_interview;

public class LeetCode_53_MaximumSubarray {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            //叠加前后两个元素
            nums[i] = Math.max(nums[i], nums[i] + nums[i - 1]);
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        return max;
    }

    public int maxSubArray2(int[] nums) {
        //到当前值为止，最大值
        int maxToCurr = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            //可能出现负值
            maxToCurr = Math.max(nums[i], maxToCurr + nums[i]);
            sum = Math.max(maxToCurr, sum);
        }
        return sum;

    }


}
