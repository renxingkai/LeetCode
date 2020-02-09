import java.awt.peer.LightweightPeer;
import java.util.*;

public class LeetCode_448 {


    public static void main(String[] arg) {

        int[] a = new int[]{1,2,3,4,7,8};
        findDisappearedNumbers1(a);

    }

    /**
     * wrong
     *
     * @param nums
     * @return
     */

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        Arrays.sort(nums);
        int begin = 0;
        int end = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] - nums[i] >= 2) {
                end = nums[i + 1];
                begin = nums[i];
            }
        }
        List<Integer> res = new ArrayList<Integer>();
        for (int i = begin + 1; i < end; i++) {
            res.add(i);
        }

        return res;

    }

    /**
     * 可以AC，但会出现一些bug
     * @param nums
     * @return
     */
    public static List<Integer> findDisappearedNumbers1(int[] nums) {
        List<Integer> ret = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            // nums[i]从1到n而下标从0开始，要减去1
            // temp是从[0,n-1]中少两个,但是有重复
            int temp = Math.abs(nums[i]) - 1;
            if (nums[temp] > 0) {
                //自己减去自己本身，会将
                nums[temp] = -nums[temp];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0)
                ret.add(i + 1);
        }

//        System.out.println(Arrays.toString(nums));
        return ret;
    }


    /**
     * 使用set方法，复杂度略高
     * @param nums
     * @return
     */
    public static List<Integer> findDisappearedNumbers2(int[] nums){
        List<Integer> res=new ArrayList<Integer>();
        Set<Integer> set = new HashSet<>();
        for (int i:nums){
            set.add(i);
        }
        for (int i=1;i<=nums.length;i++){
            if (!set.contains(i)){
                res.add(i);
            }
        }
        return res;
    }






}
