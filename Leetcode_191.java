import java.math.BigInteger;

public class Leetcode_191 {


    public static void main(String[] arg) {

        System.out.println();
    }


    /**
     * 不断与前一个数字相与，不断得到结果，如果n!=0，每次相与完count加一
     * @param n
     * @return
     */
    public static int hammingWeight(int n) {
        int count=0;
        while (n!=0){
            n&=(n-1);
            count++;
        }
        return count;
    }

}
