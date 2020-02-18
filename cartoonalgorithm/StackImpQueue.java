package cartoonalgorithm;

import java.util.Stack;

/**
 * 用栈实现队列
 */
public class StackImpQueue {

    private Stack<Integer> stackA = new Stack<Integer>();
    private Stack<Integer> stackB = new Stack<Integer>();

    /**
     * 入队
     *
     * @param element
     */
    public void enQueue(int element) {
        stackA.push(element);
    }

    /**
     * 出队
     *
     * @return
     */
    public Integer deQueue() {
        if (stackB.isEmpty()) {
            if (stackA.isEmpty()) {
                return null;
            }
            //将A栈中元素全部置于B中
            transfer();
        }
        return stackB.pop();
    }

    /**
     * 栈A元素转移到B
     */
    private void transfer() {
        while (!stackA.isEmpty()) {
            stackB.push(stackA.pop());
        }
    }
}
