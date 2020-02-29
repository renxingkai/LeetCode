package leetcode_interview;

public class LeetCode_75_SortColors {

    /**
     * 定义一个first last指针
     * first之前都是0
     * last之后都是2
     * 然后移动first和last
     * 对元素进行交换
     *
     * @param colors
     */
    public void sortColors(int[] colors) {
        if (colors == null || colors.length == 0) {
            return;
        }
        int first = 0;
        while (first < colors.length && colors[first] == 0) {
            first++;
        }
        int last = colors.length - 1;
        while (last >= 0 && colors[last] == 2) {
            last--;
        }
        //从first开始
        int index = first;
        while (index <= last) {
            if (colors[index] == 1) {
                //遇到1直接++
                index++;
            } else if (colors[index] == 0) {
                //与first交换
                switchColor(colors, first, index);
                first++;
                index++;
            } else if (colors[index] == 2) {
                switchColor(colors, last, index);
                last--;
                //index不需要向右移动，从大的区域交换过来的值，还不知道是多少
            }
        }
    }

    private void switchColor(int[] colors, int first, int index) {
        int temp = colors[first];
        colors[first] = colors[index];
        colors[index] = temp;
    }


}
