import java.util.ArrayList;
import java.util.Collections;

public class LeetCode_155 {


    public static void main(String []arg){

    }
}


class MinStack {

    private ArrayList arrayList;


    /** initialize your data structure here. */
    public MinStack() {
        arrayList=new ArrayList();
    }

    public void push(int x) {
        arrayList.add(x);
    }

    public void pop() {
        arrayList.remove(arrayList.size()-1);
    }

    public int top() {
        return (int) arrayList.get(arrayList.size()-1);
    }

    public int getMin() {
        int min= (int) arrayList.get(0);
        for(int i=1;i<arrayList.size();i++){
            if(min>(int)arrayList.get(i)){
                min=(int)arrayList.get(i);
            }else {
                continue;
            }
        }
        return min;
    }
}