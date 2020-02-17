package cartoonalgorithm;

import java.util.Stack;

/**
 * 使用一个辅助栈，minstack，只保存最小的元素
 */
public class MinStack {

    private Stack<Integer> mainStack=new Stack<Integer>();
    private Stack<Integer> minStack=new Stack<Integer>();


    public void push(int element){
        //入栈
        if (minStack.isEmpty()||element<minStack.peek()){
            minStack.push(element);
        }
        mainStack.push(element);
    }

    /**
     * 出栈
     * @return
     */
    public Integer pop(){
        if (mainStack.peek().equals(minStack.peek())){
            minStack.pop();
        }
        return mainStack.pop();
    }

    public Integer getMin() throws Exception {
        if (mainStack.isEmpty()){
            throw new Exception("stack is empty");
        }
        return minStack.peek();
    }

    public static void main(String[] args) {

    }
}
