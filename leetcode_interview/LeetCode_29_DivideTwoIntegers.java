package leetcode_interview;

import javax.swing.text.Element;

/**
 * 做除法操作，不能用已有的乘、除、取模
 */
public class LeetCode_29_DivideTwoIntegers {


    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            //除数为0，返回Integer的最大值
            return Integer.MAX_VALUE;
        }
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == -1) {
                return Integer.MAX_VALUE;
            } else if (divisor == 1) {
                return Integer.MIN_VALUE;
            }
        }
        long divd = (long) (dividend);
        long divs = (long) divisor;
        //结果正负号
        int sign = 1;
        if (divd < 0) {
            //被除数小于0
            divd = -divd;
            sign = -sign;
        }
        if (divs < 0) {
            //除数小于0
            divs = -divs;
            sign = -sign;
        }
        //将除数不断左移一位，相当于乘2
        //不断累积出*2 的个数，最终就是结果
        int res = 0;
        while (divd >= divs) {
            int shift = 0;
            while (divd >= divs << shift) {
                shift++;
            }
            //(shift - 1)是因为 上面while循环完了 shift比实际大一个
            res += (1 << (shift - 1));//还原出来 乘以了多少个2
            //移完之后，被除数减去移完的除数，继续跑循环
            divd -= (divs << (shift - 1));
        }
        return sign * res;
    }
}
