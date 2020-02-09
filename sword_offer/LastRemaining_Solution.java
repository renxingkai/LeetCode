package loadoffer;

import java.util.LinkedList;

public class LastRemaining_Solution {

    public static void main(String[] args) {

    }

    /**
     * 用约瑟夫的思想
     *
     * @param n
     * @param m
     * @return
     */
    public int LastRemaining_Solution(int n, int m) {
        if (n <= 0 || m <= 0) {
            return -1;
        }
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int removeIndex = 0;
        while (list.size() > 1) {
            removeIndex = (removeIndex + m - 1) % list.size();
            list.remove(removeIndex);
        }
        return list.get(0);

    }

    /**
     * 数学规律法
     * @param n
     * @param m
     * @return
     */
    public int LastRemaining_Solution2(int n, int m) {
        if (n <= 0 || m <= 0) {
            return -1;
        }
        int f=0;
        for (int i=2;i<=n;i++){
            f=(f+m)%i;
        }
        return f;

    }



}
