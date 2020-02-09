package leetcode_interview;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_1_TwoSum {
    /**
     * 使用HashMap存储已经有的值,用空间换时间,O(n)
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res = target - nums[i];//求出剩余的数
            if (map.containsKey(res)) {
                return new int[]{map.get(res), i};
            }
            //map中不存在res,则进行添加
            map.put(nums[i], i);

        }
        //没找到,返回[-1,-1]
        return new int[]{-1, -1};
    }
}
