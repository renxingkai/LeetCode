package upgrade_zuo;

import java.util.LinkedList;

public class AllLessNumSubArray {

    public static int getNum(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        //准备最小值和最大值的更新结构
        LinkedList<Integer> qmin = new LinkedList<Integer>();
        LinkedList<Integer> qmax = new LinkedList<Integer>();
        int L = 0;
        int R = 0;
        int res = 0;
        while (L < arr.length) {
            //L确定时，R往右扩展到最右
            while (R < arr.length) {
                //最小值结构更新
                while (!qmin.isEmpty() && arr[qmin.peekLast()] >= arr[R]) {
                    qmin.pollLast();
                }
                qmin.addLast(R);
                //最大值结构更新
                while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[R]) {
                    qmax.pollLast();
                }
                qmax.addLast(R);
                if (arr[qmax.peekFirst()] - arr[qmin.peekFirst()] > num) {
                    //不达标的情况
                    break;
                }
                R++;
            }
            //查看下标过期没有
            if (qmin.peekFirst() == L) {
                qmin.pollFirst();
            }
            if (qmax.peekFirst() == L) {
                qmax.pollFirst();
            }
            //一次性加上所有以L开头的子数组数量
            res += R - L;
            L++;
        }
        return res;


    }

}
