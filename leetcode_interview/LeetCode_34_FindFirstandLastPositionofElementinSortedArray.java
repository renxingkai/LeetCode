package leetcode_interview;

public class LeetCode_34_FindFirstandLastPositionofElementinSortedArray {


    /**
     * 二分法
     * mid==target时
     * 1)找起点
     * 2）找结尾
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        if (nums == null || nums.length == 0) {
            return res;
        }
        int start = 0;
        int end = nums.length - 1;
        //二分法去搜索首尾
        while (nums[start] < nums[end]) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < target) {
                start = mid + 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                //target和mid相等
                //移动start到target相等位置
                //once nums[mid] == target:
                if (nums[start] != nums[mid]) {
                    start++;//move start to lower bound (first position)
                } else {
                    end--;//move end to higher bound (last position)
                }
            }
        }
        if (nums[start] == target && nums[end] == target) {
            res[0] = start;
            res[1] = end;
        }
        return res;
    }

}
