package common_question;

import java.util.Arrays;

public class BubbleSort {

    /**
     * 插入排序
     *
     * @param nums
     * @return
     */
    public static int[] bubbleSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        for (int i = 0; i < nums.length; i++) {
            //设置没有交换的标志
            boolean flag = false;
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j + 1] < nums[j]) {
                    int temp=nums[j+1];
                    nums[j+1]=nums[j];
                    nums[j]=temp;
                    flag=true;
                }
            }
            if (!flag){
                break;
            }
        }
        return nums;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 2, 5, -3, 5, 7, 4, 1, 2};
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(bubbleSort(nums)));
    }

}
