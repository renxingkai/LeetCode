package leetcode_interview;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class LeetCode_46_Permutations {

    /**
     * 全排列
     * 递归
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        LinkedList<List<Integer>> res=new LinkedList<List<Integer>>();
        if (nums==null|nums.length==0){
            return res;
        }
        permuteHelper(res,new LinkedList<Integer>(),nums,new HashSet<Integer>());
        return res;
    }

    /**
     *
     * @param res
     * @param clist 当前list的状态
     * @param nums
     * @param set 记录是否用过当前数字
     */
    private void permuteHelper(LinkedList<List<Integer>> res, LinkedList<Integer> clist, int[] nums, HashSet<Integer> set) {
        if (clist.size()==nums.length){
            //把所有的数字都填进来了
            res.add(new LinkedList<>(clist));
        }else {
            for (int i=0;i<nums.length;i++){
                if (!set.contains(nums[i])){
                    //添加到当前列表
                    clist.add(nums[i]);
                    //递归返回后，需要记录last，从set和clist中删除
                    int last=clist.size()-1;
                    //记录用到过nums[i]
                    set.add(nums[i]);
                    permuteHelper(res,clist,nums,set);
                    set.remove(nums[i]);
                    clist.remove(last);//index, not value
                }
            }
        }


    }


}
