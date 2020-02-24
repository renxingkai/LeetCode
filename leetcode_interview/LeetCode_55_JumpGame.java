package leetcode_interview;

public class LeetCode_55_JumpGame {

    public boolean canJump(int[] nums) {
        if (nums.length < 2) {
            return true;
        }
        int reach = 0;
        //i <= reach往前走 必须是在能到达范围之内的数
        for (int i = 0; i < nums.length && i <= reach; i++) {
            //nums[i]为num[i]所能走的步长，+i加上当前的位置
            reach = Math.max(nums[i] + i, reach);
            if (reach >= nums.length-1) {
                return true;
            }
        }
        return false;
    }

}
