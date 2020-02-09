import java.util.Arrays;

public class LeetCode_268 {

    public static void main(String[] arg) {
        int[] a = new int[]{0, 2};
        System.out.println(missingNumber(a));
    }

    /**
     * 求出正常的数组之和和减去该数组元素之和，结果即为空缺的元素
     * @param nums
     * @return
     */
    public static int missingNumber(int[] nums) {
        int index = 0;
        int count = 0;
        for (int i = 0; i <= nums.length; i++) {
            count += i;
        }
        for (int i = 0; i < nums.length; i++) {
            index += nums[i];
        }
        return count - index;
    }

}
