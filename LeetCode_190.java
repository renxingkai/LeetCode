import java.math.BigInteger;
import java.util.Arrays;

public class LeetCode_190 {

    public static void main(String[] arg) {
        System.out.println(reverseBits(43261596));
    }
    //思路：利用亦或^运算，让一个32位的数，这个数只有一位为1，其他为0，1从
    //最右位开始循环，如果n和1对应的那一位是1那么结果为非0，否则为0，因此可以
    //利用这个特点将n的二进制位倒过来，并保存在一个数组中，最后在计算
    public static int reverseBits(int n) {
        int []re=new int[32];
        System.out.println(Arrays.toString(re));
        int flag=1;
        int index=31;
        //如果用int可能存在溢出问题
        long reslut=0;
        while (flag!=0){
            if ((flag&n)!=0){
                //相异为一
                re[index]=1;
            }
            //如果出现为0情况，说明遇到了1 则直接左移，因为re初始化为0
            //标识位左移
            flag=flag<<1;
            index--;
        }
        for(int i=31;i>=0;i--){
            reslut+=re[i]*Math.pow(2, i);
        }
        return (int)reslut;

    }

    //大佬答案一，依次将n的末尾位给result的末尾位，并且result向左移31次
    public int reverseBits1(int n) {
        int result = 0;
        int i = 0;
        while (i < 32) {
            int temp = n & 0x01;
            n = n >> 1;

            result = (result << 1) | temp;
            i++;
        }
        return result;
    }
    //大佬答案
    public static int reverseBits2(int n) {
        int count = 0;
        for(int i = 31;i >= 0;i--){
            count = (n >>> i & 1) << (31-i) | count;
        }
        return count;
    }

}
