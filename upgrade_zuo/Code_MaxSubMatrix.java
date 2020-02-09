package upgrade_zuo;

import java.util.Stack;

public class Code_MaxSubMatrix {

    public static int maxRecSize(int[][] map) {
        if (map == null || map.length == 0 || map[0].length == 0) {
            return 0;
        }
        int maxArea = 0;
        int height[] = new int[map[0].length];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                height[i] = map[i][j] == 0 ? 0 : height[i] + 1;
            }
            maxArea = Math.max(maxRecFromBottom(height), maxArea);
        }
        return maxArea;
    }


    /**
     * 一个数组为底的情况，能找到的最大矩形
     * 一个数组表示直方图，在其中找到的最大正方形
     * [4,3,2,5,6]
     *
     * @param height
     * @return
     */
    public static int maxRecFromBottom(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int maxArea = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < height.length; i++) {
            //一个栈元素要弹出时，结算弹出这个元素响应最大的格子
            while (!stack.isEmpty() && height[i] <= height[stack.peek()]) {
                //结算
                int j = stack.pop();
                int k = stack.isEmpty() ? -1 : stack.peek();//k是左边界 ，如果弹出后栈为空，则为-1，否则是弹出之后的栈顶
                //当前弹出区域，扩了多少格子
                int curArea = (i - k - 1) * height[j];
                maxArea = Math.max(maxArea, curArea);
            }
            stack.push(i);
        }
        //栈中剩下的元素
        while (!stack.isEmpty()) {
            int j = stack.pop();
            int k = stack.isEmpty() ? -1 : stack.peek();
            int curArea = (height.length - k - 1) * height[j];
            maxArea = Math.max(maxArea, curArea);
        }
        return maxArea;
    }

}
