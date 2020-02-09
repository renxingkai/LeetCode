public class LeetCode_317 {

    public static void main(String[] arg) {
        System.out.println(getSum(5, 7));
    }

    /**
     * 使用公式a+b=a^b+(a&b)<<1
     *      a^b 表示a+b 中每位不进位的和，表示a与b各位求和 101 ^ 010=111
     *      (a&b) <<1   二进制加法 1&1=1,把1左移以为10，1+1=10，表示a+b 所有进位；
     * @param a
     * @param b
     * @return
     */
    public static int getSum(int a, int b) {
        int sum=a^b;
        int carry=(a&b)<<1;
        //当进位不为0时，需要不断循环进位
        while (carry!=0){
            a=(sum^carry);
            b=(sum&carry)<<1;
            sum=a;
            carry=b;
        }
        return sum;
    }


}
