package leetcode_interview;

public class LeetCode_26_RemoveDuplicatesfromSortedArray {
    /**
     * 使用两个指针fast和slow
     * fast指针全遍历，遇到不同的放到slow上
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int slow = 1;
        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[fast - 1] != nums[fast]) {
                nums[slow++] = nums[fast];
            }
        }
        return slow;
    }

}
