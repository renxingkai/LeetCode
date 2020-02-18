package leetcode_interview;

/**
 * 使用滑动窗口法
 * 注意到题目限定的条件：该数组中的元素均是正整数。
 * 因此我们可以用滑动窗口法来解决，当和小于s时，滑动窗口右端点向右移动，
 * 使窗口增大；当和大于s时，滑动窗口左端点向右移动，使窗口缩小。
 * <p>
 * 时间复杂度是O(n)，其中n为nums数组的长度。空间复杂度是O(1)。
 */
public class LeetCode_209_MinimumSizeSubarraySum {

    public int minSubArrayLen(int s, int[] nums) {
        int left = 0;
        int right = -1;
        int sum = 0;
        int res = nums.length + 1;
        while (left < nums.length) {
            if (right + 1 < nums.length && sum < s) {
                //右指针往右扩
                right++;
                sum += nums[right];
            } else {
                //左指针往右扩,缩小sum值,先减再加
                sum -= nums[left];
                left++;
            }
            if (sum >= s) {
                //sum大于s时,去取出最大连续子数组
                res = Math.min(res, right - left + 1);
            }
        }
        if (res == nums.length + 1) {
            //并没有找到符合要求的连续子数组
            return 0;
        } else {
            return res;
        }


    }

}
