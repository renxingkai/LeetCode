import java.util.Arrays;

//题目大意：给定数组A，现在可以选择 一个x ，x的值在[-k,k]之间可以选择。A中的每项可以选择一个x来相加，问新数组B的最大最小值的差最小是多少。
//
//解题思路：其实就是比较A的最大最小值和 2k之间的关系
public class LeetCode_908 {

    public static void main(String[] arg) {
        System.out.println(smallestRangeI(new int[]{0,10}, 2));
    }

    public static int smallestRangeI(int[] A, int K) {
        Arrays.sort(A);
        int temp = A[A.length - 1] - A[0];
        if (temp <= 2*K) {
            return 0;
        } else {
            return (int) (temp - 2*K);
        }
    }

}
