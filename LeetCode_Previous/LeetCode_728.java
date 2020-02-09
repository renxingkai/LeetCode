import java.util.ArrayList;
import java.util.List;

/**
 * public static void main(String[] args){
 *         int s=1831;
 *         int g = s%10;
 *         int sw = s/10%10;
 *         int b = s/100%10;
 *         int q = s/1000%10;
 *         System.out.println("个位数是:"+g+";十位数是:"+sw+";百位数是："+b+";千位数是："+q);
 *     }
 * 结果:个位数是:1;十位数是:3;百位数是：8;千位数是：1
 *
 *
 * 此题使用不断取出每个数字的各个位数，然后用原数字对其取余判断余数是否为0来进行验证
 * //(j%10==0)不断将小数点向前移动，将后一位数字进行舍弃（舍弃顺序个、十、百、千。。。）来判断初始数字中是否有0元素数字
 * //(i%(j%10))!=0来判断i%每一个位数是否为0
 */
public class LeetCode_728 {

    public static void main(String []arg){
        for (int i:selfDividingNumbers(1, 22)){
            System.out.print(i+" ");
        }
//        selfDividingNumbers(1, 22);
    }

    public static List<Integer> selfDividingNumbers(int left, int right) {
        //返回结果
        ArrayList<Integer> result=new ArrayList<Integer>();
        for(int i=left;i<=right;i++){
            int j=i;
            //不断除10取余数
            for(;j>0;j/=10){
                //(j%10==0)来判断初始数字中是否有0元素数字
                //(i%(j%10))!=0来判断i%每一个位数是否为0
                if((j%10==0)||(i%(j%10))!=0)break;
            }
            if (j==0){
                result.add(i);
            }

        }
        return result;
    }


}
