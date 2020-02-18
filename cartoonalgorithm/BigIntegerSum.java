package cartoonalgorithm;

public class BigIntegerSum {

    /**
     * 借助数组，大整数求和
     *
     * @param bigNumberA
     * @param bigNumberB
     * @return
     */
    public static String bigNumberSum(String bigNumberA, String bigNumberB) {
        //1.把两个大整数用数组逆序存储，数组长度等于较大的整数位数+1
        int maxLength = bigNumberA.length() > bigNumberB.length() ?
                bigNumberA.length() : bigNumberB.length();
        int[] arrayA = new int[maxLength + 1];
        for (int i = 0; i < bigNumberA.length(); i++) {
            arrayA[i] = bigNumberA.charAt(bigNumberA.length() - i - 1) - '0';
        }
        int[] arrayB = new int[maxLength + 1];
        for (int i = 0; i < bigNumberB.length(); i++) {
            arrayB[i] = bigNumberB.charAt(bigNumberB.length() - i - 1) - '0';
        }
        //2.构建result数组，数组长度等于较大整数位数+1
        int[] result = new int[maxLength + 1];
        //遍历数组，按位相加
        for (int i = 0; i < result.length; i++) {
            int temp = result[i];
            temp += arrayA[i];
            temp += arrayB[i];
            if (temp >= 10) {
                //大于10要进位
                temp = temp - 10;
                result[i + 1] = 1;
            }
            result[i] = temp;
        }
        //4.把result数组中的元素逆序转为String
        StringBuilder sb = new StringBuilder();
        //是否找到大整数的最高有效位
        boolean findFirst = false;
        for (int i = result.length - 1; i >= 0; i++) {
            //找到第一个不是0的位置
            if (!findFirst) {
                if (result[i] == 0) {
                    //跳过0的元素
                    continue;
                }
                findFirst = true;
            }
            sb.append(result[i]);
        }
        return sb.toString();
    }


}
