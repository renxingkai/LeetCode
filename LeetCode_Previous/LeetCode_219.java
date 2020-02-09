import java.util.HashMap;
import java.util.Map;

/**
 * 直接用Map来进行保存，然后进行判断两个相同的元素的索引值差是否小于等于k
 */
public class LeetCode_219 {

    public static void main(String[] arg) {
        System.out.println(containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 1));
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {

        if (nums.length < 2 || nums == null) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            //如果不存在的话，直接加入该元素
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], i);
            } else {
                //如果存在nums[i]，获取其对应的索引
                int j = map.get(nums[i]);
                //如果之间的距离小于k，则返回true
                if ((i - j) <= k) {
                    return true;
                } else {
                    map.put(nums[i], i);
                }
            }
        }
        return false;
    }
}





