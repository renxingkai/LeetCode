package leetcode;

public class TrailingZeros {

    public static void main(String[] args) {

    }

    //    https://github.com/azl397985856/leetcode/blob/master/problems/172.factorial-trailing-zeroes.md
    public int trailingZeroes(int n) {
        int count=0;
        while (n>=5){
            n=n/5;
            count+=n;
        }
        return count;
    }

}
