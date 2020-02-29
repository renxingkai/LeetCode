package leetcode_interview;

import java.util.LinkedList;
import java.util.List;

/**
 * 返回集合所有的子集
 */
public class LeetCode_78_Subsets {

    /**
     * 可以加可以不加 1 2 3
     * "" 1
     * "" ""
     * "" 2
     * "" 1 2
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        LinkedList<List<Integer>> result = new LinkedList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        subsetsHelper(nums, 0, result, new LinkedList<Integer>());
        return result;
    }

    private void subsetsHelper(int[] nums, int curIdx, LinkedList<List<Integer>> result, LinkedList<Integer> cur) {
        if (curIdx == nums.length) {
            //数组处理完了
            result.add(new LinkedList<Integer>(cur));
        }else {
            //不选当前的数字cur 没有加nums[curIdx]
            subsetsHelper(nums,curIdx+1,result,cur);
            //选上当前的数字
            cur.add(nums[curIdx]);
            subsetsHelper(nums,curIdx+1,result,cur);
            //递归回来把当前加的数字删除
            cur.remove(cur.size()-1);
        }

    }

}
