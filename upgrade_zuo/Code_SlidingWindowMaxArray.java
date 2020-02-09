package upgrade_zuo;

import java.util.LinkedList;

public class Code_SlidingWindowMaxArray {

    public static int[] getMaxWindow(int[] arr, int w) {
        if (arr == null || w < 1 || arr.length < w) {
            return null;
        }
        //LinkedList双向链表  保持从大到小排列
        LinkedList<Integer> qmax = new LinkedList<Integer>();
        int[] res = new int[arr.length - w + 1];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            //arr[qmax.peekLast()] <= arr[i] 双端队列尾部值 所代表的数组的值 小于等于当前值
            while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i]) {
                //弹出尾部
                qmax.pollLast();
            }
            qmax.addLast(i);
            if (qmax.peekFirst() == i - w) {
                //双端队列头部的值 过期了
                qmax.pollFirst();
            }
            if (i >= w - 1) {
                //窗口形成 填充res
                res[index++] = arr[qmax.peekFirst()];
            }
        }
        return res;
    }


}
