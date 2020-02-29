package leetcode_interview;

import java.util.Stack;

public class LeetCode_84_LargestRectangleinHistogram {

    /**
     * 对于高度heights[i]，如果知道左侧比它小的高度和右侧比它小的高度
     * 则heights[i]所对应的面积就确定了
     *
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        //记录结果
        int max = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (int curr = 0; curr < heights.length; curr++) {
            if (stack.isEmpty() || heights[curr] >= heights[stack.peek()]) {
                //当前高度大于栈顶元素
                //当前值大于stack.peek()栈顶元素，要push进来当前值的索引
                stack.push(curr);
            } else {
                //当前位置比stack.peek要小
                //right为当前最高值右面一个的索引
                int right = curr;
                //找到了比curr高的节点index
                int index = stack.pop();
                while (!stack.isEmpty() && heights[index] == heights[stack.peek()]) {
                    //如果出现了高度相同的情况
                    index = stack.pop();
                }
                //leftMost左边界 比height[index]小的数的index
                int leftMost = (stack.isEmpty()) ? -1 : stack.peek();
                max = Math.max(max, (right - leftMost - 1) * heights[index]);
                //不能改变，要继续处理curr位置
                //继续查看stack中比curr小的元素的面积
                curr--;
            }
        }
        //以上遍历一遍处理完了最大值存在的面积
        //但是栈中可能还是有元素
        //当前栈中最高高度右边比它小的第一个数，左边比他小的第一个数是stack.pop
        int rightMost = stack.peek() + 1;
        while (!stack.isEmpty()) {
            int index = stack.pop();
            int left = (stack.isEmpty()) ? -1 : stack.peek();
            max = Math.max(max, (rightMost - left - 1) * heights[index]);
        }
        return max;
    }

}
