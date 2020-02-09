public class LeetCode_263 {


    public static void main(String[] arg) {
        System.out.println(isUgly(-2147483648));
    }

    /**
     * 如果能被2 3 5除完，则商结果一定为1
     * @param num
     * @return
     */
    public static boolean isUgly(int num) {
        if (num == 1) {
            return true;
        }
        if (num<=0){
            return false;
        }
        while (num%2==0){
            num/=2;
        }
        while (num%3==0){
            num/=3;
        }
        while (num%5==0){
            num/=5;
        }


        return num==1;
    }




}
