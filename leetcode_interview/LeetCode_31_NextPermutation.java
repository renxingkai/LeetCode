package leetcode_interview;

import java.util.Arrays;

public class LeetCode_31_NextPermutation {

    /**
     * 找到下一个相邻的比nums大的数字
     * 123-->132
     *
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        //倒数第二个数字
        int replace = nums.length - 2;
        while (replace >= 0) {
            //找到第一个比它后面大的数
            // 从右往左数字小的数字，然后可以交换
            if (nums[replace] < nums[replace + 1]) {
                break;
            }
            replace--;
        }
        if (replace < 0) {
            //此时 6 5 4 3 2 1
            Arrays.sort(nums);
            return;
        }
        //从replace往后找，找到一个比replace大，并且最接近replace的数
        int largerIndex = replace + 1;
        //12642-->14226
        while (largerIndex < nums.length && nums[largerIndex] > nums[replace]) {
            largerIndex++;//largerIndex会到了最后一个2,之前的数就是要找的数
        }
        int temp = nums[largerIndex - 1];
        nums[largerIndex - 1] = nums[replace];
        nums[replace] = temp;
        //把最后的区域排序
        Arrays.sort(nums, replace + 1, nums.length);
    }
}
