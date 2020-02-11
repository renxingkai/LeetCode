package leetcode_interview;

public class LeetCode_11_ContainerWithMostWater {

    /**
     * 双指针问题
     * 使用左右指针
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        if (height == null || height.length < 2) {
            //必须大于等于3
            return 0;
        }
        int left = 0;//左边指针
        int right = height.length - 1;//右指针
        int area = 0;//能围出来的面积
        while (left < right) {
            area = Math.max(area, Math.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right]) {
                //左指针所在的高度小于右指针所在高度
                //左指针往右移,才会有可能使area变大
                left++;
            } else if (height[left] > height[right]) {
                right--;
            } else {
                //两指针所在高度相同时，需要同时移动
                left++;
                right--;
            }
        }
        return area;
    }

}
