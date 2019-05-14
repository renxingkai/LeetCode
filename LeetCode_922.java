import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class LeetCode_922 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortArrayByParityII(new int[]{4,2,5,7})));
    }


    public static int[] sortArrayByParityII(int[] A) {
        ArrayList<Integer> odd = new ArrayList<>();
        ArrayList<Integer> even = new ArrayList<>();

        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                even.add(A[i]);
            } else {
                odd.add(A[i]);
            }
        }
        //对奇数数组和偶数数组进行排序
        Collections.sort(odd);
        Collections.sort(even);
        for (int i = 0; i < A.length; i++) {
            if (i % 2 == 0) {
                A[i]=even.get(i/2);
            } else {
                A[i]=odd.get(i/2);
            }
        }
        return A;

    }
}
