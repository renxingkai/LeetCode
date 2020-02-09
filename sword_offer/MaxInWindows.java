package loadoffer;

import java.util.ArrayList;
import java.util.Arrays;

public class MaxInWindows {

    public static void main(String[] args) {

    }

    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(size <= 0 || num.length <= 0)	return list;

        int[] temp = new int[size];
        for(int i = 0;i <= num.length - size;i ++) {
            int j = i;
            int count = 0;	//计数器
            while(count < size) {
                temp[count ++] = num[j ++];
            }

            Arrays.sort(temp);
            list.add(temp[temp.length - 1]);
        }

        return list;

    }
}
