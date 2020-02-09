package leetcode;

public class RemoveDuplicates {

    public static void main(String[] args) {

    }

    public int removeDuplicates(int[] nums) {
        int j=0;
        for (int i=1;i<nums.length;i++){
            if (nums[j]!=nums[i]){
                nums[++j]=nums[i];
            }
        }
        return j+1;
    }

}
