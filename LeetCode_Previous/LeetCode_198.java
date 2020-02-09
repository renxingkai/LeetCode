public class LeetCode_198 {

    public static void main(String[] arg) {
        int[] a = new int[]{2, 1, 1, 2};
        System.out.println(rob(a));
    }

    /**
     * 简单的动态规划问题，题目意思是计算数组中 不相邻数字最大之和。
     * <p>
     * 比如  [ 1, 3, 4, 5, 3, 2 ]  应返回 10 ， 3 + 5 + 2 = 10 。
     * <p>
     * n个房屋所能抢到的最大的金额 = max （n-1 个房屋所能抢到的最大金额 ， n-2 个房屋所能抢到的最大金额+第n个房屋的金额），这样用一个数组来保存当前房屋能抢到的最大金额数。  
     * <p>
     * 拿上面的例子来继续看具体过程
     * <p>
     * [ 1,      3,      4,     5,     3,       2 ]  
     * <p>
     * 当前位置对应的最大数值为：
     * <p>
     *   1        3       5      8     8        10
     * <p>
     * 计算过程  ： 数组第一个元素 所对应的最大值即自己本身 1； 第二个元素所对应的最大值为 max（1,3） = 3； 第三个元素所对应的最大值为max（ 3 , 1+4 ）= 5  ； 第四个元素所对应的最大值为 max（ 5， 3+5 ）= 8 ；  第五个元素所对应的最大值为max（ 8 ， 3+5）= 8； 第六个元素所对应的最大值为 max（ 8，8+2）= 10。 所以 最后结果为 1。
     * <p>
     * 嗯。。注意array[1]的数值 应该是max（nums[0],nums[1]） 而不是 nums[1]，自己在写的时候犯了这个错，还一直找不出来。。。
     * <p>
     * ---------------------
     * <p>
     * 本文来自 Pi_dan 的CSDN 博客 ，全文地址请点击：https://blog.csdn.net/qq_38595487/article/details/80037402?utm_source=copy
     *
     * @param nums
     * @return
     */
    public static int rob(int[] nums) {
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
