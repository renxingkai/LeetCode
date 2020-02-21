package cartoonalgorithm;

/**
 * 三个问题:
 * 1.一个无序数组中有99个不重复的正整数，范围是1--100，
 * 唯独缺少一个1--100中的整数，如何找出这个缺失的整数?
 * A: 先算出1+2+...+100的和，然后依次减去数组中的数，最终得到的差值就是缺少的数
 * <p>
 * 2.一个无序数组中有若干个正整数，范围是1--100,其中99个整数都出现了偶数次，
 * 只有1个整数出现了奇数次，如何找到这个出现了奇数次的整数？
 * A:利用异或运算，相同为0，不同为1，两两数依次异或，最终留下的就是仅出现奇数次的数字
 * <p>
 * 3.一个无序数组中有若干个正整数，范围是1--100,其中99个整数都出现了偶数次，
 * 有2个整数出现了奇数次，如何找到这2个出现了奇数次的整数A B？
 * A:使用分治法思想，先将所有数字异或，最终得到A B的异或结果 ,eg:00000110B,
 * 说明第二位A B不同为1，
 * 则把整个数组根据第二位进行分组，每个组中依次异或，最终得出两个数，就是A B
 */
public class MissValue {

    public static int[] findLostNum(int[] array) {
        //用于存储2个出现奇数次的整数
        int[] result = new int[2];
        //第一次进行整体异或运算
        int xorResult = 0;
        for (int i = 0; i < array.length; i++) {
            xorResult ^= array[i];
        }
        //如果异或结果为0，则说明全部出现了2次，
        if (xorResult == 0) {
            return null;
        }
        //确定两个整数的不同位，以此来做分组
        int separator = 1;
        while (0 == (xorResult & separator)) {
            separator <<= 1;
        }
        //第二次进行分组异或运算
        for (int i = 0; i < array.length; i++) {
            if (0 == (array[i] & separator)) {
                result[0] ^= array[i];
            } else {
                result[1] ^= array[i];
            }
        }
        return result;
    }

}
