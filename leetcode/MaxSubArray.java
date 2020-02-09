package leetcode;

public class MaxSubArray {

    public static void main(String[] args) {

    }

    public int maxSubArray(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        if (nums.length==1){
            return nums[0];
        }
        int max=nums[0];
        for (int i=1;i<nums.length;i++){
            //叠加前后两个元素
            nums[i]=Math.max(nums[i],nums[i]+nums[i-1]);
            if (nums[i]>max){
                max=nums[i];
            }
        }
        return max;
    }

}
