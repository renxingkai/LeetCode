package leetcode_interview;

import java.util.Stack;

public class LeetCode_85_MaximalRectangle {

    /**
     * 一行一行看，类似数大厦高度
     *
     * @param matrix
     * @return
     */
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int[] heights = new int[col];
        int max = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                //遍历每一个数字
                if (matrix[i][j] == '1') {
                    //对应位置是1 之前位置+1
                    heights[j]++;
                } else {
                    heights[j] = 0;
                }
            }
            int area = largestRectangleArea(heights);
            max = Math.max(max, area);
        }
        return max;
    }

    private int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int max = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (int curr = 0; curr < heights.length; curr++) {
            if (stack.isEmpty() || heights[curr] >= heights[stack.peek()]) {
                //大于栈顶元素
                stack.push(curr);
            } else {
                int right = curr;
                int index = stack.pop();
                while (!stack.isEmpty() && heights[index] == heights[stack.peek()]) {
                    index = stack.pop();
                }
                int leftMost = (stack.isEmpty()) ? -1 : stack.peek();
                max = Math.max(max, (right - leftMost - 1) * heights[index]);
                curr--;
            }
        }
        int rightMost = stack.peek() + 1;
        while (!stack.isEmpty()) {
            int index = stack.pop();
            int left = (stack.isEmpty()) ? -1 : stack.peek();
            max = Math.max(max, (rightMost - left - 1) * heights[index]);
        }
        return max;
    }


}
