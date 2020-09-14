package common_question;

import java.util.Arrays;

public class InsertSort {

    /**
     * 插入排序
     *
     * @param nums
     * @return
     */
    public static int[] insertSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        for (int i = 1; i < nums.length; i++) {
            //外层循环从左往右走
            for (int j = i; j > 0; j--) {
                //内层循环从右往左走
                if (nums[j] < nums[j - 1]) {
                    //从小到大排序
                    int temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = temp;
                }
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 2, 5, -3, 5, 7, 4, 1, 2};
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(insertSort(nums)));
    }

}
