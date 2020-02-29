package leetcode_interview;

public class LeetCode_80_RemoveDuplicatesfromSortedArrayII {
    //每个数字最多重复两次，返回删除之后的数组
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length <= 2) {
            return nums.length;
        }
        //loc从第三个数字开始
        int loc = 2;
        for (int idx = 2; idx < nums.length; idx++) {
            //12223
            //nums[loc - 1] == nums[idx]当前数字不等于loc-1的数字，可以把当前数字移动到loc数组中
            //nums[loc - 1] == nums[loc - 2]
            if (!(nums[loc - 1] == nums[loc - 2] && nums[loc - 1] == nums[idx])) {
                nums[loc++] = nums[idx];
            }
        }

        return loc;
    }


}
