package leetcode_interview;

import java.util.Arrays;

public class LeetCode_4_MedianofTwoSortedArrays {

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if ((nums1.length == 0 || nums1 == null) && (nums2.length == 0 || nums2 == null)) {
            return 0;
        }
        //两个数组排个序，取中间？
        int[] all_nums = new int[nums1.length + nums2.length];
        for (int i = 0; i < nums1.length; i++) {
            all_nums[i] = nums1[i];
        }
        for (int j = 0; j < nums2.length; j++) {
            all_nums[j + nums1.length] = nums2[j];
        }
        Arrays.sort(all_nums);
        if (all_nums.length % 2 == 0) {
            return (all_nums[all_nums.length / 2] + all_nums[all_nums.length / 2 - 1]) / 2.0;
        } else {
            return all_nums[all_nums.length / 2];
        }
    }


    /**
     * 网上解法
     * https://www.jianshu.com/p/21f570caca89
     * 大致思路:
     * 用两个变量 分别分割nums1和nums2 分割变量一边的分为同一组，
     * 不停移动分割变量，直到两组变量同时满足条件
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays2(nums2, nums1);
        }
        int x = nums1.length;
        int y = nums2.length;
        int low = 0;
        int high = x;

        while (low <= high) {
            //数组是从小到大排完序的,最小值在最左边，最大值在最右边
            int partitionX = (low + high) / 2;//num1数组中的
            int partitionY = (x + y + 1) / 2 - partitionX;
            //取出左边范围的最大值和右边范围的最小值
            //如果partition==0,则取最小值作为最大值
            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
            //取出右边范围最小值
            int minRightX = (partitionX == x) ? Integer.MAX_VALUE : nums1[partitionX];
            int minRightY = (partitionY == y) ? Integer.MAX_VALUE : nums2[partitionY];

            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                //已达到平衡，不需要移动
                if ((x + y) % 2 == 0) {
                    //偶数个数
                    return (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY) / 2);
                } else {
                    //奇数个数
                    return Math.max(maxLeftX, maxLeftY);
                }
                //移动partition
            } else if (minRightX < maxLeftY) {
                low = partitionX + 1;
            } else {
                //minLeftX<maxRightY
                high = partitionX - 1;
            }

        }
        return 0.0;
    }


}


