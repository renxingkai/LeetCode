import org.omg.CORBA.INTERNAL;

import java.util.HashSet;
import java.util.Set;

public class LeetCode_349 {

    public static void main(String[] arg) {

    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> nums = new HashSet<Integer>();
        Set<Integer> results = new HashSet<Integer>();
        //添加nums2到集合中，直接将重复的也添加进去，和nums1对比
        for (int i = 0; i < nums2.length; i++) {
            nums.add(nums2[i]);
        }

        //遍历nums1，查看是否有相同的元素，即与nums的交集
        for (int i = 0; i < nums1.length; i++) {
            if (nums.contains(nums1[i])) {
                //如果有相同的，直接加入result集合
                results.add(nums1[i]);
            } else {
                continue;
            }
        }
        //遍历集合，添加到返回数组中
        int[] result = new int[results.size()];
        int i = 0;
        for (int res : results) {
            result[i++] = res;
        }
        return result;
    }

}
