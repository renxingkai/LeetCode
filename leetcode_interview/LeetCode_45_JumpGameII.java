package leetcode_interview;

public class LeetCode_45_JumpGameII {

    public int jump(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        int curMax = 0;
        int nextMax = 0;
        int step = 0;
        int index = 0;
        while (index <= curMax) {
            while (index <= curMax) {
                //小循环按着当前的值，计算nextMax值
                nextMax = Math.max(nextMax, index + nums[index]);
                index++;
            }
            //走到了最远的位置
            curMax = nextMax;
            step++;
            if (curMax >= nums.length - 1) {
                return step;
            }
        }
        return 0;
    }


}
