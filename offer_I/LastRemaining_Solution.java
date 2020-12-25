package offer_I;

import java.util.LinkedList;

public class LastRemaining_Solution {

    public int LastRemaining_Solution(int n, int m) {
        if (n == 0 || m <= 0) {
            return -1;
        }
        LinkedList<Integer> res = new LinkedList<Integer>();
        for (int i = 0; i < n; i++) {
            res.add(i);
        }
        int index = 0;
        while (res.size() > 1) {
            index=(index+m-1)%res.size();
            res.remove(index);
        }
        return res.size()==1?res.get(0):-1;


    }
}
