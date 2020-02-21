package cartoonalgorithm;

import java.beans.IntrospectionException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 拆红包问题
 */
public class DivideRedPackage {

    /**
     * 二倍均值法
     * 假设剩余红包金额 为m元，剩余人数为n，那么有如下公式:
     * 每次抢到的金额=随机区间[0.01,m/n*2-0.01] 元
     *
     * @param totalAmount
     * @param totalPeopleNum
     * @return
     */
    public static List<Integer> divideRedPackage(Integer totalAmount, Integer totalPeopleNum) {
        List<Integer> amountList = new ArrayList<Integer>();
        //剩余金额
        Integer restAmount = totalAmount;
        //剩余人数
        Integer resPeopleNum = totalPeopleNum;
        Random random=new Random();
        for (int i=0;i<totalPeopleNum-1;i++){
            //随机范围:[1,剩余人均金额的2倍-1]分
            int amount=random.nextInt(restAmount/resPeopleNum*2-2)+1;
            restAmount-=amount;
            resPeopleNum--;
            amountList.add(amount);
        }
        amountList.add(restAmount);
        return amountList;
    }




    public static void main(String[] args) {
        List<Integer> amoutList=divideRedPackage(1000,10);
        for (Integer amout:amoutList){
            System.out.println("抢到:"+new BigDecimal(amout).divide(new BigDecimal(100)));
        }
    }


    /**
     * 方法二:线段切割法
     * 当n个人一起抢总金额为m的红包时，需要做n-1次随机运算，以此确定n-1个切割点
     * 随机的范围区间是[1,m-1]
     * 当所有的切割点确定以后，子线段的长度也就随之确定了
     */
}
