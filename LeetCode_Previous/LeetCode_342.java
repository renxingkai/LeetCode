public class LeetCode_342 {

    public static void main(String[] arg) {

    }

    /**
     * 循环。任一个数如果是4的幂，则重复除以4的话最后会得到一个1。
     * 例：64/4=16，16/4=4，4/4=1。且除的过程中全部都是整除，没有余数。可以用这个思路判断num是不是4的幂。
     *
     * @param num
     * @return
     */
    public static boolean isPowerOfFour1(int num) {
        //判断num为0情况
        if (num == 0) {
            return false;
        }
        while (num != 1 && num % 4 == 0) {
            //任一个数如果是4的幂，则重复除以4最终会得到一个1
            num /= 4;
        }
        //如果重复相除之后，最终得到1，则说明num是4的倍数，否则不是
        if (num == 1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     *不循环。首先一个数如果是4的幂，那这个数一定是2的幂，如：4^2=（2^2）^2=2^4，所以首先判断num是不是2的幂，
     * 如果num是2的幂，则化为二进制的话 一定是10…0的形式，即1后面跟一串0。
     * 所以num-1一定是01…1的形式，即0后面跟一串1，并且位数相同。所以num&(num-1)=0。
     * 如果满足这个条件则num是2的幂。 如果num是2的幂则接下来判断num是不是4的幂，因为4^n=(2^2)^n=2^(2n)。
     * 所以如果num是4的幂，则化为二进制一定是1后面跟偶数个0的形式。故判断num&0x55555555，因为0x55555555的奇数位均为1，而num如果是4的幂，1后面跟偶数个0，则num的1也在奇数位，其他位为0，故两者相与一定为1。
     * 如果num是2 的幂而不是4的幂，则化为二进制形式为1后面跟奇数个0，这样num为1的那一位一定在偶数位，其他位为0。0x55555555的偶数位全为0，故两者相与一定为0。
     *
     * @param num
     * @return
     */
    public static boolean isPowerOfFour2(int num) {
        if(num<=0)
            return false;
        //判断num是2的幂并且是否是4的幂
        return (num & num-1)==0 && (num&0x55555555)==num;

    }

}
