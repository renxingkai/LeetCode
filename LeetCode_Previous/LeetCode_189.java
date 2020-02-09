import java.util.Arrays;

public class LeetCode_189 {

    public static void main(String[] arg) {
        rotate(new int[]{1, 2, 3,4,5}, 3);
    }

    public static void rotate(int[] nums, int k) {
        int[] res=new int[nums.length];
        int order=0;
        //不写取余，测试样例会有[-1] 2类似的样例
        for(int i=nums.length-k%nums.length;i<nums.length;i++){
            res[order++]=nums[i];
        }
        for (int i=0;i<nums.length-k%nums.length;i++){
            res[order++]=nums[i];
        }
        for (int i=0;i<nums.length;i++){
            nums[i]=res[i];
        }
        System.out.println(Arrays.toString(nums));
    }

    public static int[] reverseArray(int A[]) {
        int[] result = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            result[i] = A[A.length - i - 1];
        }
        return result;
    }

}
