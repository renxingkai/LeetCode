package offer_I;

import java.util.Stack;

public class IsPopOrder {


    public boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> stack=new Stack<>();
        int index=0;
        for (int i=0;i<pushA.length;i++){
            stack.push(pushA[i]);
            while (!stack.isEmpty()&&stack.peek()==popA[index]){
                index++;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

}
