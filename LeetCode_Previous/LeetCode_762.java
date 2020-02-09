import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//https://blog.csdn.net/u011439455/article/details/80674722
public class LeetCode_762 {


    public static void main(String[] arg) {

    }


    public int countPrimeSetBits(int L, int R) {
        //列举出20以内的素数，然后进行判断运算
        Set<Integer> set = new HashSet<>(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19));
        int res = 0;
        for (int i = L; i <= R; i++) {
            int tmp = i;
            int cnt = 0;
            while (tmp != 0) {
                if ((tmp & 1) == 1) cnt++;
                tmp >>= 1;
            }
            if (set.contains(cnt)) res++;
        }
        return res;

    }

}
