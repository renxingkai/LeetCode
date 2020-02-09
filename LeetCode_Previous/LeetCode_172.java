/**
 * 需要考虑10是由2*5得到的，但是2出现的次数比5多，所以只需要考虑5出现的次数，出现一次5则末尾会有一个0
 * 但是考虑5时候，不仅要考虑单个5的个数，还需要考虑25 125这样由多个5组成的数字
 */
public class LeetCode_172 {

    public static void main(String[] arg) {
        System.out.println(trailingZeroes(100));
    }

    public static int trailingZeroes(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n / 5;
            n = n / 5;
        }
        return sum;
    }

}
