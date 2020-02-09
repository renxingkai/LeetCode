public class LeetCode_367 {


    public static void main(String[] arg) {
        System.out.println(isPerfectSquare2(808201));
    }

    /**
     *
     * 直接通过遍历1--num/2的数字i，然后判断i*i是否和num相等
     * 但是仅pass 了1.37%的人
     * @param num
     * @return
     */
    public static boolean isPerfectSquare(int num) {
        if (num==0||num==1){
            return true;
        }
        int compare=num/2;
        for (int i=1;i<=compare;i++){
            if (i*i==num){
                return true;
            }else {
                continue;
            }
        }
        return false;
    }

    /**
     * 思路二：
     *      有dalao使用数学trick
     *      所有的完全平方数都可以被表示成奇数和1+3+5+7+9 ...
     *      超过了24.8%
     * @param num
     * @return
     */
    public static boolean isPerfectSquare1(int num) {
        int i=1;
        while (num>0){
            num-=i;
            i+=2;
        }
        return num==0;
    }

    /**
     * 思路三：
     *      使用二分查找法，记得用long 要不过不了
     * @param num
     * @return
     */
    public static boolean isPerfectSquare2(int num) {
        if (num<1){
            return false;
        }
        if (num==1){
            return true;
        }
        long left=0;
        long right=num;
        long mid;
        while (left<=right){
            mid=left+(right-left)/2;
            if (mid*mid==num){
                return true;
            }else if (mid*mid<num){
                left=mid+1;
            }else {
                right=mid-1;
            }
        }
        return false;
    }

}
