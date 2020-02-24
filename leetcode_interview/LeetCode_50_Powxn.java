package leetcode_interview;

public class LeetCode_50_Powxn {

    /**
     * 对奇数n进行处理，先提取出一个x，x*x^n-1,则指数就变成偶数了
     * 使用二分法
     *
     * @param num
     * @param power
     * @return
     */
    public double myPow(double num, int power) {
        if (power < 0) {
            num = 1 / num;
            power = -power;
        }
        return pow(num, power);
    }

    private double pow(double num, int power) {
        if (num == 1) return num;
        if (power == 0) return 1;
        double p=pow(num,power/2);
        if (power%2!=0){
            //奇数
            //多乘以一个num
            return num*p*p;
        }
        //偶数
        return p*p;
    }
}
