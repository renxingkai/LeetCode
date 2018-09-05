import java.util.Arrays;

/**
 * 先对数组进行排序，然后直接判断相邻两个数字是否相同即可
 */
public class LeetCode_217 {

    public static void main(String[] arg) {
        System.out.println(containsDuplicate(new int[] {1,1,1,3,3,4,3,2,4,2}));
    }

    public static boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-1; i++) {
                if (nums[i] != nums[i+1]) {
                    continue;
                } else {
                    return true;
                }
            }

        return false;
    }


}
