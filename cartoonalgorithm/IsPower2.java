package cartoonalgorithm;

public class IsPower2 {


    /**
     * 复杂度为
     * O(1)
     * 2的幂次n
     * n-1
     * n&(n-1)==0
     *
     * @param num
     * @return
     */
    public static boolean isPower2(int num) {
        return (num & num - 1) == 0;
    }

}
