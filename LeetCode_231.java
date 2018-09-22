public class LeetCode_231 {

    public static void main(String[] arg) {
        System.out.println(isPowerOfTwo(1));
    }

    /**
     * 循环法
     * @param n
     * @return
     */
    public static boolean isPowerOfTwo(int n) {
        if (n==0){
            return false;
        }
        while (n%2==0){
            n/=2;
        }
        return n==1?true:false;
    }

    /**
     * 位运算法
     * @param n
     * @return
     */
    public static boolean isPowerOfTwo1(int n) {
        return n>0&&(n&(n-1))==0;
    }

}
