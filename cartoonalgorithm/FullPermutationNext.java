package cartoonalgorithm;

import java.util.Arrays;

/**
 * 获取一个全排列下一个数的3个步骤
 * 1.从后向前查看逆序区域，找到逆序区域的前一位，也就是数字置换的边界。
 * 2.让逆序区域的前一位和逆序区域中大于它的最小的数字交换位置。
 * 3.把原来的逆序区域转为顺序状态。
 */
public class FullPermutationNext {

    public static int[] findNearstNum(int[] numbers) {
        //1.从后向前查看逆序区域，找到逆序区域的前一位，也就是数字置换的边界
        int index = findTransferPoint(numbers);
        //如果数字置换边界是0,说明整个数组已经逆序，无法得到更大的相同数字组成的整数，返回null
        if (index == 0) {
            return null;
        }
        //2.把逆序区域的前一位和逆序区域中刚刚大于它的数字交换位置
        //复制并入参，避免直接修改入参
        int[] numbersCopy = Arrays.copyOf(numbers, numbers.length);
        exchangedHead(numbersCopy, index);
        //3.把原来的逆序区域转为顺序
        reverse(numbersCopy, index);
        return numbersCopy;
    }

    /**
     * 12453-->12435
     * 把原来的逆序区域转为顺序
     *
     * @param numbersCopy
     * @param index
     */
    private static int[] reverse(int[] numbersCopy, int index) {
        for (int i = index, j = numbersCopy.length - 1; i < j; i++, j--) {
            int temp = numbersCopy[i];
            numbersCopy[i] = numbersCopy[j];
            numbersCopy[i] = temp;
        }
        return numbersCopy;
    }

    /**
     * 让逆序区域的前一位和逆序区域中大于它的最小的数字交换位置
     * 12354-->12453
     *
     * @param numbersCopy
     * @param index
     */
    private static int[] exchangedHead(int[] numbersCopy, int index) {
        int head = numbersCopy[index - 1];
        for (int i = numbersCopy.length - 1; i > 0; i--) {
            if (head < numbersCopy[i]) {
                numbersCopy[index - 1] = numbersCopy[i];
                numbersCopy[i] = head;
                break;
            }
        }
        return numbersCopy;
    }

    /**
     * 从后向前查看逆序区域，找到逆序区域的前一位，也就是数字置换的边界
     *
     * @param numbers
     * @return
     */
    private static int findTransferPoint(int[] numbers) {
        for (int i = numbers.length - 1; i > 0; i--) {
            if (numbers[i - 1] > numbers[i]) {
                return i;
            }
        }
        return 0;
    }


}
