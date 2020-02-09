package cn.rxk;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 此题提供两种思路
 */
public class LeetCode_136 {

    public static void main(String[] arg) {

    }

    /**
     * 思路二：
     * 将所有元素放入Set，如果Set中有的话，就删除，set中的元素，最终Set中留下的就是仅出现一个的元素
     * 超过11.%
     *
     * @param nums
     * @return
     */
    public static int singleNumber2(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            //遍历Set中元素，如果存在的话，则删除set中该元素
            if (set.contains(nums[i])) {
                set.remove(nums[i]);
            } else {
                //不存在该元素，则进行添加该元素
                set.add(nums[i]);
            }
        }
        int result=0;
        //通过迭代的方式获取set中留存的元素
        for (Iterator<Integer> i=set.iterator();i.hasNext();){
            result=i.next();
        }
        return result;
    }


    /**
     * 思路一：
     * 如果将array排序后，那么相同的数字一定位于相邻的位置上，只需要比较2k和2k+1位置上的值是否相同就可以了。
     *超过30%
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums) {
        //排序数组
        Arrays.sort(nums);
        //对数组进行遍历，判断相邻两个数字是否相同，此处每次索引+2
        for (int i = 0; i < nums.length - 1; i += 2) {
            if (nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }
        //否则，不相同的数字在末尾
        return nums[nums.length - 1];
    }


}
