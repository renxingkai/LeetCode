package cartoonalgorithm;

/**
 * 一个整数，删去K个数字，使得剩下的数字最小
 * 思路:
 * 把原整数的所有数字从左到右进行比较，如果发现某一位数字大于它右面的数字，
 * 那么在删除该数字后，必然会使该数位的值降低
 */
public class RemoveKDigitsMin {

    /**
     * 借助栈
     * O(n)
     *
     * @param num
     * @param k
     * @return
     */
    public static String removeKDigitsMin(String num, int k) {
        //新整数的最终长度=原整数长度-k
        int newLength = num.length() - k;
        //创建一个栈，用于接收所有数字
        char[] stack = new char[num.length()];
        //栈顶标记
        int top = 0;
        for (int i = 0; i < num.length(); i++) {
            //遍历当前数字
            char c = num.charAt(i);
            //当栈顶数字大于遍历到的当前数字时，栈顶数字出栈(相当于删除数字)
            while (top > 0 && stack[top - 1] > c && k > 0) {
                //出栈
                top -= 1;
                //删除一个数字
                k -= 1;
            }
            //遍历到的当前数字入栈
            stack[top++] = c;

        }
        //找到栈中第一个非零数字的位置，以构建新的整数字符串
        int offset = 0;
        //栈中数字是从左到右存储
        while (offset < newLength && stack[offset] == '0') {
            offset++;
        }
        //从第一个非0位置开始构造数字
        return offset == newLength ? "0" :
                new String(stack, offset, newLength - offset);
    }


}
