package leetcode_interview;

import java.util.Arrays;

public class LeetCode_16_3SumClosest {

    /**
     * 仍然是双指针问题
     *
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return target;
        }
        //sort first
        Arrays.sort(nums);
        int delta = nums[0] + nums[1] + nums[2] - target;
        for (int i = 0; i < nums.length - 2; i++) {
            //i为base
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                //左右指针移动
                int newDelta = nums[i] + nums[start] + nums[end] - target;
                if (newDelta == 0) {
                    return target;
                }
                if (Math.abs(newDelta) < Math.abs(delta)) {
                    //小于要更新
                    delta = newDelta;
                }
                if (newDelta < 0) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        return delta + target;
    }


}
