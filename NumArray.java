import java.util.Arrays;

public class NumArray {


    private int[] num;

    public NumArray(int[] nums) {
        num = nums;
        System.out.println(Arrays.toString(num));
    }

    public int sumRange(int i, int j) {
        int count = 0;
        for (; i < j; i++) {
            count += num[i];
        }
        return count;
    }

    public static void main(String[] arg) {

    }

}
