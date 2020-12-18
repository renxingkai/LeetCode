package offer_I;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class GetLeastNumbers_Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> res=new ArrayList<>();
        if (input.length<k||input.length==0){
            return res;
        }
        PriorityQueue<Integer> priorityQueue=new PriorityQueue<>((o1,o2)->(o2-o1));
        for (int i=0;i<input.length;i++){
            if (priorityQueue.size()<k){
                priorityQueue.add(input[i]);
            }else {
                priorityQueue.add(input[i]);
                priorityQueue.poll();
            }
        }
        for (int num:priorityQueue){
            res.add(num);
        }
        return res;
    }
}
