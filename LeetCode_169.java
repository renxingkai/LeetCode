/**
 * 使用Map集合，如果里面存在num[i]，则对num[i]的值进行+1操作
 *            如果里面不存在num[i]，则对map中该元素进行添加，并把值赋为1
 */

import java.util.HashMap;
import java.util.Map;

public class LeetCode_169 {

    public static void main(String[] arg) {
        int[] num = new int[]{3,2,3};
        System.out.println(majorityElement(num));

    }

    public static int majorityElement(int[] nums) {
        int times = nums.length / 2;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        //遍历num数组
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                //如果里面存在num[i]，则对num[i]的值进行+1操作
                map.put(nums[i], map.get(nums[i]) + 1);
            }else {
                //如果里面不存在num[i]，则对map中该元素进行添加，并把值赋为1
                map.put(nums[i], 1);
            }
        }
        //判断值是否大于n/2
        for (Map.Entry<Integer, Integer> vo : map.entrySet()) {
            if (vo.getValue() > times) {
                return vo.getKey();
            }
        }
        return 0;
    }

}
