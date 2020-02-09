public class LeetCode_326 {

    public static void main(String[] arg) {
        int x=9999;
        int count=0;
        while (x!=0){
            count++;
            
        }
    }

    /**
     * @param n
     * @return
     */
    public static boolean isPowerOfThree1(int n) {
        //判断num为0情况
        if (n == 0) {
            return false;
        }
        while (n != 1 && n % 3 == 0) {
            //任一个数如果是3的幂，则重复除以3最终会得到一个1
            n /= 3;
        }
        //如果重复相除之后，最终得到1，则说明num是4的倍数，否则不是
        if (n == 1) {
            return true;
        } else {
            return false;
        }
    }


    /**
     * 题目要求不能使用循环或者递归，这里需要用到数学的一点小技巧。
     * <p>
     * 首先如果n《=0，那么一定返货false
     * <p>
     * 如果n是3的x次方，那么y=log3(n)一定是一个整数，而且3^y一定等于n
     * <p>
     * 在java里没有底为3的log对数运算，所以这里需要用到换底公式
     *
     * @param n
     * @return
     */
    public static boolean isPowerOfThree2(int n) {
        if (n <= 0) {
            return false;
        }
        if (Math.pow(3, Math.round(Math.log(n) / Math.log(3))) == n) {
            return true;
        }
        return false;
    }


}
