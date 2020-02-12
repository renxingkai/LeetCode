package leetcode_interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LeetCode_15_3Sum {

    /**
     * 双指针问题
     * 选用base ，然后left指针和right指针在base之外的其他数组进行查找
     * 需要注意，仅需要找不同的元素
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length <= 2) {
            return res;
        }
        int n = nums.length;
        int i = 0;
        //先进行排序
        Arrays.sort(nums);
        while (i < n - 2) {
            int base = nums[i];
            //左指针
            int left = i + 1;
            //右指针
            int right = n - 1;
            //循环左右指针
            while (left < right) {
                int sum = base + nums[left] + nums[right];
                if (sum == 0) {
                    //相等
                    LinkedList<Integer> list = new LinkedList<Integer>();
                    list.add(base);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    res.add(list);
                    //移动左右指针
                    //左指针向右移动
                    left = moveRight(nums, left + 1);
                    //右指针向左移动
                    right = moveLeft(nums, right - 1);
                } else if (sum < 0) {
                    //sum<0
                    //左指针向右移动
                    left = moveRight(nums, left + 1);
                } else {
                    //右指针向左移动
                    right = moveLeft(nums, right - 1);
                }
            }
            //i往右移动
            i=moveRight(nums,i+1);
        }
        return res;
    }

    private int moveLeft(int[] nums, int i) {
        //和移动之前元素相同
        while (i == nums.length - 1 || (i >= 0 && nums[i] == nums[i + 1])) {
            i--;
        }
        return i;

    }

    private int moveRight(int[] nums, int i) {
        //和移动之前元素相同
        while (i == 0 || (i < nums.length) && (nums[i - 1] == nums[i])) {
            i++;
        }
        return i;
    }

}
