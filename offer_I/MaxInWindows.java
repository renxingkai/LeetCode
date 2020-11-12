package offer_I;

import java.util.ArrayList;
import java.util.LinkedList;

public class MaxInWindows {

    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        //保存结果
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (num == null || num.length < size || size < 1) {
            return res;
        }
        //单调栈，使用队列来模拟
        LinkedList<Integer> qMax = new LinkedList<Integer>();
        for (int i = 0; i < num.length; i++) {
            while (!qMax.isEmpty() && num[qMax.peekLast()] < num[i]) {
                //单调栈中的队尾元素比当前元素小的情况下，则进行弹出
                qMax.pollLast();
            }
            //此时可以保证单调栈中的元素都小于num[i]
            qMax.addLast(i);
            //判断是否需要弹出栈中的首个元素，因为滑窗已经滑过去了
            if (i - size == qMax.peekFirst()) {
                qMax.pollFirst();
            }
            //形成了滑动窗口，需要将元素添加到res列表中
            if (i >= size - 1) {
                res.add(num[qMax.peekFirst()]);
            }

        }
        return res;
    }


    public static void main(String[] args) {

    }

}
