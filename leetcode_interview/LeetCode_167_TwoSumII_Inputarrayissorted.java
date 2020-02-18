package leetcode_interview;

public class LeetCode_167_TwoSumII_Inputarrayissorted {

    /**
     * 双指针
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        int left=0;
        int right=numbers.length-1;
        while (left<right){
            if (numbers[left]+numbers[right]==target){
                break;
            }else if (numbers[left]+numbers[right]>target){
                //大于，因为是有序，right--
                right--;
            }else {
                left++;
            }
        }
        return new int[]{left+1,right+1};
    }

}
