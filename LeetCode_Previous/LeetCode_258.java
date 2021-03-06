public class LeetCode_258 {

    public static void main(String []arg){

    }

    /**
     * 题目的意思很简单，输入一个int型数字num，将num的每个位加起来，重复这个过程，直到结果只有个位数为止，即结果为0～9.
     *
     * 我的第一反应是，写一个循环，一直算，算到结果只有个位数时停止，但这个方法显然效率不高，而且，题目下方的提示说存在O(1)时间的算法。
     *
     * 既然结果只能是0～9，有没有可能是按这个规律一直重复呢？
     *
     * 在草稿纸上写一写：
     *
     * 0～9的结果就是0～9
     *
     * 10～19的结果是1、2、3 …… 9、1
     *
     * 20～29的结果是1、2、3 …… 9、1
     *
     * 可以发现，0属于特殊情况，后面每9个数字就一次循环，1～9一直循环下去，而且结果等于num对9取余，这同样适用于num=0的情况。
     *
     * 拿题目的例子验证一下，38%9=2，看来没错
     *
     * 但其实还存在问题，18%9=0，但18对应的结果应该是9(1+8=9)，那么我们可以再稍作修改，结果=(num-1)%9 + 1，这次是正确的。
     *
     * 代码就非常简单了，只需一行：
     * @param num
     * @return
     */
    public static int addDigits(int num) {
        return 1+(num-1)%9;
    }


}
