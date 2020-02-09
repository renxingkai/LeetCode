package loadoffer;

import java.util.Stack;

public class IsPopOrder {


    public static void main(String[] args) {
        int[] pushA = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] popA = {7, 8, 6, 4, 5, 3, 2, 1};
        System.out.println(IsPopOrder(pushA, popA));
    }

    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        if (pushA.length<=0||popA.length<=0){
            return false;
        }
        int j=0;
        Stack<Integer> s1=new Stack<Integer>();
        for (int i=0;i<pushA.length;i++){
            s1.push(pushA[i]);
            if (pushA[i]==popA[j]){
                if (j++==popA.length-1){
                    //遍历完所有的栈内元素
                    return true;
                }
                s1.pop();
            }
        }
        while (!s1.isEmpty()){
            if (s1.pop()!=popA[j++]){
                return false;
            }
        }
        return true;
    }

}
