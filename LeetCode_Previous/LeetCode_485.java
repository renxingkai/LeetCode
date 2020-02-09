public class LeetCode_485 {

    public static void main(String[] arg) {
        System.out.println(findMaxConsecutiveOnes(new int[]{1, 1, 0, 1, 1, 1}));
    }

    /**
     * 最大连续1的个数
     * @param nums
     * @return
     */
    public static int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]==1){
                count++;
            }else {
                if (count>=max){
                    max=count;
                }
                count=0;
            }
        }
        return count>max?count:max;
    }


}
