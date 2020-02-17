package cartoonalgorithm;

public class GCD {

    /**
     * 辗转相除法
     *O(log(max(a,b))) 取模运算较慢
     * @param a
     * @param b
     * @return
     */
    public static int getGreatestCommonDivisonrV2(int a, int b) {
        int big = a > b ? a : b;
        int small = a > b ? b : a;
        if (big % small == 0) {
            return small;
        }
        return getGreatestCommonDivisonrV2(big % small, small);
    }


    /**
     * 更相减损术
     * a和b的最大公约数为:
     * a-b的差值c和较小数b的最大公约数
     *
     * O(max(a,b))
     * @param a
     * @param b
     * @return
     */
    public static int getGreatestCommonDivisonrV3(int a, int b) {
        if (a == b) {
            return a;
        }
        int big = a > b ? a : b;
        int small = a > b ? b : a;
        return getGreatestCommonDivisonrV3(big - small, small);

    }


    /**
     * 结合辗转相除法和更相减损术
     * 移位运算
     * 当a和b均为偶数时，gcd(a,b)=2*gcd(a/2,b/2)=2*gcd(a>>1,b>>1)
     * 当a偶,b奇时，gcd(a,b)=gcd(a/2,b)=gcd(a>>1,b)
     * 当a奇,b偶时，gcd(a,b)=gcd(a,b/2)=gcd(a,b>>1)
     * 当a奇,b奇时，先用更相减损术运算一次，gcd(a,b)=gcd(b,a-b),
     * 此时a-b为偶数，然后继续移位
     * <p>
     * 左移除2，右移乘2
     *
     * O(log(max(a,b)))
     * @param a
     * @param b
     * @return
     */
    public static int getGreatestCommonDivisonrV4(int a, int b) {
        if (a == b) {
            return a;
        }
        if ((a & 1) == 0 && (b & 1) == 0) {
            //a b均为偶数
            return getGreatestCommonDivisonrV4(a >> 1, b >> 1) << 1;
        } else if ((a & 1) == 0 && (b & 1) != 0) {
            //a为偶数，b为奇数
            return getGreatestCommonDivisonrV4(a >> 1, b);
        } else if ((a & 1) != 0 && (b & 1) == 0) {
            //a为奇数 ，b为偶数
            return getGreatestCommonDivisonrV4(a, b >> 1);
        } else {
            int big = a > b ? a : b;
            int small = a > b ? b : a;
            return getGreatestCommonDivisonrV4(big - small, small);
        }
    }

    public static void main(String[] args) {

    }


}
