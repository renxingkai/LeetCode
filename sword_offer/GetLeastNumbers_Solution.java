package loadoffer;

import java.util.ArrayList;
import java.util.Arrays;

public class GetLeastNumbers_Solution {


    public static void main(String[] args) {

    }

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list=new ArrayList<Integer>();
        if (k>input.length){
            return list;
        }
        Arrays.sort(input);
        for (int i=0;i<k;i++){
            list.add(input[i]);
        }
        return list;
    }

}
