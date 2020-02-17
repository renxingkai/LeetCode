package leetcode_interview;

public class LeetCode_35_SearchInsertPosition {
    //二分法
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0;
        int right = nums.length - 1;
        while (start+1<right) {
            int mid = start + (right - start) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        //最终left和right相邻
        if (nums[start] >= target) {
            return start;
        }else if (nums[right] < target) {
            return right + 1;
        }else {
            return right;
        }

    }


}
