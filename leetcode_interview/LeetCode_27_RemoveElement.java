package leetcode_interview;

public class LeetCode_27_RemoveElement {

    /**
     * 使用fast和slow指针
     * fast不断加。
     * 当nums[fast]!=val则，把nums[fast]放到slow上去
     *
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0 || nums == null) {
            return 0;
        }
        int slow = 0;
        int fast = 0;
        for (; fast < nums.length; fast++) {
            if (nums[fast] != val) {
                nums[slow++] = nums[fast];
            }
        }
        return slow;
    }


}
