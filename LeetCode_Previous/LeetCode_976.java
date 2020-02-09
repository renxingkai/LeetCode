import java.util.Arrays;

public class LeetCode_976 {
    //https://blog.csdn.net/u013383813/article/details/86438724
    public static void main(String[]arg) {

    }

    //组成三角形的条件 a<=b<=c ，a > c - b;
    public static int largestPerimeter(int[] A) {

        Arrays.sort(A);
        for (int i = A.length - 1; i >= 2; i--) {
            if (A[i] - A[i - 1] < A[i - 2]) {
                return A[i] + A[i - 1] + A[i - 2];
            }
        }
        return 0;

    }


}
