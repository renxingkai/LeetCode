package leetcode;

public class TwoSum {

    public static void main(String[] args) {

    }

    public int[] twoSum(int[] numbers, int target) {
        if (numbers==null||numbers.length<2){
            return numbers;
        }
        int start=0;
        int end=numbers.length-1;
        int sum;
        while (start<=end){
            sum=numbers[start]+numbers[end];
            if (target==sum){
                break;
            }else if (sum>target){
                end--;
            }else {
                start++;
            }
        }
        return new int[]{start+1,end+1};
    }

}
