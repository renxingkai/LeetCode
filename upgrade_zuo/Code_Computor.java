package upgrade_zuo;

import java.util.LinkedList;

public class Code_Computor {


    public static int getValue(String str) {
        return value(str.toCharArray(), 0)[0];
    }

    /**
     * 返回值为数组，长度为2
     * arr[0]为计算结果
     * arr[1]为计算到的位置
     *
     * @param str
     * @param i
     * @return
     */
    public static int[] value(char[] str, int i) {
        LinkedList<String> que = new LinkedList<String>();
        int pre = 0;
        int[] bra = null;
        while (i < str.length && str[i] != ')') {
            //没到最后，并且没有遇到右括号
            if (str[i] >= '0' && str[i] <= '9') {
                //收集数字，984
                pre = pre * 10 + str[i++] - '0';
            } else if (str[i] != '(') {
                //遇到符号  收集数字和符号
                addNum(que, pre);
                que.addLast(String.valueOf(str[i++]));
                //归0 pre 重新收集
                pre = 0;
            } else {
                //当前i位置遇到了左括号
                //从i+1位置开始，把它与之相配对的右括号匹配出来计算出结果
                bra = value(str, i + 1);
                //计算结果放置bra[0]
                pre = bra[0];
                //终止位置为bra[1] ，相当于返回了()中的计算，并从()接下来开始的位置算
                i = bra[1] + 1;
            }
        }
        //遇到右括号了，或者遍历完了，要算出之前的值并返回
        addNum(que, pre);
        return new int[]{getNum(que), i};
    }

    private static void addNum(LinkedList<String> que, int num) {
        if (!que.isEmpty()) {
            int cur = 0;
            String top = que.pollLast();
            if (top.equals("+") || top.equals("-")) {
                //链表中遇到了+和-，则直接把+ -入链表
                que.addLast(top);
            } else {
                //取出链表中的当前值
                cur = Integer.valueOf(que.peekLast());
                //与要进来的num进行运算
                num = top.equals("*") ? num * cur : cur / num;
            }
        }
        que.addLast(String.valueOf(num));
    }


    public static int getNum(LinkedList<String> que) {
        int res = 0;
        boolean add = true;
        String cur = null;
        int num = 0;
        while (!que.isEmpty()) {
            cur = que.pollFirst();
            if (cur.equals("+")) {
                add = true;
            } else if (cur.equals("-")) {
                add = false;
            } else {
                num = Integer.valueOf(cur);
                res += add ? num : -num;
            }
        }
        return res;
    }

}
