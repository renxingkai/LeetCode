package common_question;

import java.util.Arrays;

public class QuickSort {


    public static int[] quickSort(int[] nums, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return null;
        }
        int pivot = partition(nums, startIndex, endIndex);
        quickSort(nums, startIndex, pivot - 1);
        quickSort(nums, pivot + 1, endIndex);
        return nums;
    }

    private static int partition(int[] nums, int startIndex, int endIndex) {
        int pivot = nums[startIndex];//哨兵元素
        //左右指针
        int left = startIndex;
        int right = endIndex;
        while (left != right) {
            while (left < right && nums[right] > pivot) {
                right--;
            }
            while (left < right && nums[left] <= pivot) {
                left++;
            }
            if (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
        }
        //pivoit和指针重合点交换
        nums[startIndex] = nums[left];
        nums[left] = pivot;
        return left;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 2, 5, -3, 5, 7, 4, 1, 2};
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(quickSort(nums, 0, nums.length - 1)));
    }

}
