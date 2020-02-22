package leetcode_interview;

public class LeetCode_41_FirstMissingPositive {

    /**
     * 返回第一个缺少的正整数
     *
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }
        for (int i = 0; i < nums.length; i++) {
            //先把小于等于0的数字改为MAX
            if (nums[i] <= 0) {
                nums[i] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            int num = Math.abs(nums[i]);
            if (num <= nums.length) {
                //将num位置的数取反
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }
        //返回第一个大于0的索引，即为第一个缺少的正整数
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return nums.length + 1;

    }

}
