package offer_I;

import java.util.PriorityQueue;

public class MidNum {

    PriorityQueue<Integer> left=new PriorityQueue<>((o1,o2)->(o2-o1));
    PriorityQueue<Integer> right=new PriorityQueue<>();

    int index=0;

    /**
     * 根据index的值，来确定所求的中位数
     * @return
     */
    public Double GetMedian() {
        if (index%2==0){
            return Double.valueOf((left.peek()+right.peek())/2.0);
        }else {
            return Double.valueOf(right.peek());
        }
    }

    /**
     * 先往左边加，再往右边加
     * @param num
     */
    public void Insert(Integer num) {
        if(index%2==0){
            //先左后右
            left.add(num);
            right.add(left.poll());
        }else {
            //先右后左
            right.add(num);
            left.add(right.poll());
        }
        index++;
    }

    public static void main(String[] args) {

    }

}
