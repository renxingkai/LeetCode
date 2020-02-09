package leetcode;

public class SingleNumber {

    public static void main(String[] args) {
        System.out.println(7^4);
    }

    /**
     * 异或的性质 两个数字异或的结果a^b是将 a 和 b 的二进制每一位进行运算，得出的数字。 运算的逻辑是 如果同一位的数字相同则为 0，不同则为 1
     *
     * 异或的规律
     *
     * 任何数和本身异或则为0
     *
     * 任何数和 0 异或是本身
     *
     * 很多人只是记得异或的性质和规律，但是缺乏对其本质的理解，导致很难想到这种解法（我本人也没想到）
     *
     * bit 运算
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int res=0;
        for (int num:nums){
            res=res^num;
        }
        return res;
    }

}
