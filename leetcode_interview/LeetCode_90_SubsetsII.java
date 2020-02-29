package leetcode_interview;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 输入有重复数字
 */
public class LeetCode_90_SubsetsII {

    /**
     * 如果两个数字相同，
     * 前一个数字没有被取到，后一个数字被取到了就会出现重复
     * @param nums
     * @return
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        LinkedList<List<Integer>> result = new LinkedList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        subsetsHelper(nums, 0,true, result, new LinkedList<Integer>());
        return result;
    }

    /**
     *
     * @param nums
     * @param curIdx
     * @param taken 前面的数字(直接相邻)是否被取到
     * @param result
     * @param cur
     */
    private void subsetsHelper(int[] nums, int curIdx, boolean taken,LinkedList<List<Integer>> result, LinkedList<Integer> cur) {
        if (curIdx == nums.length) {
            //数组处理完了
            result.add(new LinkedList<Integer>(cur));
        }else {
            //不选当前的数字cur 没有加nums[curIdx]
            subsetsHelper(nums,curIdx+1,false,result,cur);
            if (taken||nums[curIdx-1]!=nums[curIdx]){
                //选上当前的数字
                cur.add(nums[curIdx]);
                //取当前cur
                subsetsHelper(nums,curIdx+1,true,result,cur);
                //递归回来把当前加的数字删除
                cur.remove(cur.size()-1);
            }
        }

    }

}
