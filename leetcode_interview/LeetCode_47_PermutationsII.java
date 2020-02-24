package leetcode_interview;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * 输入可能包含重复的数字
 */
public class LeetCode_47_PermutationsII {

    /**
     * 全排列
     * 递归
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null | nums.length == 0) {
            return null;
        }
        LinkedList<List<Integer>> res = new LinkedList<List<Integer>>();
        Arrays.sort(nums);
        permuteHelper(nums, new boolean[nums.length], new LinkedList<Integer>(), res);
        return res;
    }

    private void permuteHelper(int[] nums, boolean[] used, LinkedList<Integer> curList, LinkedList<List<Integer>> res) {
        if (curList.size() == nums.length) {
            //把所有的数字都填进来了
            res.add(new LinkedList<>(curList));
        } else {
            //当前数字之前给的是哪个数字
            int preNum = nums[0] - 1;
            for (int i = 0; i < nums.length; i++) {
                //判断当前数 和之前是不同的
                if ((used[i] == false) && (nums[i] != preNum)) {
                    //没用过数字
                    preNum = nums[i];
                    //添加到当前列表
                    curList.add(nums[i]);
                    used[i] = true;
                    permuteHelper(nums, used, curList, res);
                    used[i] = false;
                    curList.remove(curList.size() - 1);//index, not value
                }
            }
        }

    }


}
