package leetcode;

public class Rob {

    public static void main(String[] args) {

    }

    public int rob(int[] nums) {
        if (nums.length == 0 || nums == null) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return nums[0] > nums[1] ? nums[0] : nums[1];
        }
        int[] array = new int[nums.length];//保存每个房子最多抢劫的值
        //n个房屋所能抢到的最大的金额 = max （n-1 个房屋所能抢到的最大金额 ， n-2 个房屋所能抢到的最大金额+第n个房屋的金额），
        // 这样用一个数组来保存当前房屋能抢到的最大金额数。  
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                array[0] = nums[0];
            } else if (i == 1) {
                array[1] = Math.max(nums[0],nums[1] );
            } else {
                array[i] = Math.max(array[i - 1], array[i - 2] + nums[i]);
            }
        }
        return array[nums.length-1];
    }

}
