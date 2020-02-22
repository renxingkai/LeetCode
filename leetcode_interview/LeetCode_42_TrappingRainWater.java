package leetcode_interview;

public class LeetCode_42_TrappingRainWater {

    public int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }
        int max = 0;
        int leftmax = 0;
        int rightmax = 0;
        //左右指针
        int i = 0;
        int j = height.length - 1;
        while (i < j) {
            leftmax = Math.max(leftmax, height[i]);
            rightmax = Math.max(rightmax, height[j]);
            //leftmax<rightmax时，左指针的水量就会先确定
            if (leftmax < rightmax) {
                //左边的确定
                max += leftmax - height[i];
                i++;
            } else {
                //右边的确定
                max += rightmax - height[j];
                j--;
            }
        }
        return max;
    }


}
