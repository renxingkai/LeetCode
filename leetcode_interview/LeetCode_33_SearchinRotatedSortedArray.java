package leetcode_interview;

import javax.naming.spi.DirObjectFactory;

public class LeetCode_33_SearchinRotatedSortedArray {

    /**
     * 要求O(log n)
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            //找到二分mid位置
            //避免overflow
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                //已经找到了
                return mid;
            }
            if (nums[start] < nums[mid]) {
                if (nums[start] <= target && target <= nums[mid]) {
                    end = mid;//右指针移到mid
                } else {
                    start = mid;
                }
            } else if (nums[mid] < nums[end]) {
                //此时start比mid大
                if (nums[end] >= target && nums[mid] <= target) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
        }
        if (nums[start] == target) return start;
        if (nums[end] == target) return end;
        return -1;
    }


    public static void main(String[] args) {

    }


}
