package leetcode_interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 递归去做
 */
public class LeetCode_39_CombinationSum {


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        if (candidates == null || candidates.length == 0 || target <= 0) {
            return results;
        }
        //先进行排序
        Arrays.sort(candidates);
        combinationSumHelper(candidates, target, 0, results, new ArrayList());
        return results;

    }

    /**
     * @param candidates
     * @param target
     * @param index
     * @param results
     * @param curSeq     当前已经有的组合是什么
     */
    private void combinationSumHelper(int[] candidates,
                                      int target, int index,
                                      List<List<Integer>> results,
                                      ArrayList curSeq) {
        if (target == 0) {
            //达到目标，可以添加results
            results.add(new ArrayList<Integer>(curSeq));
        } else if (target > 0) {
            //target大于0
            for (int i = index; i < candidates.length; i++) {
                if (candidates[i] > target) {
                    //此时不可能再加入candidates[i]了
                    break;
                }
                curSeq.add(candidates[i]);
                //递归
                //新的target 为target 减去已经取了的candidates[i]
                combinationSumHelper(candidates, target - candidates[i], i, results, curSeq);
                //移掉加进去的，回溯
                curSeq.remove(curSeq.size() - 1);
            }
        }


    }
}
