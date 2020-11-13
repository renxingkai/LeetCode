package offer_I;

public class FindNumsAppearOnce {

    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        int a = 0;
        int b = 0;
        //对所有数据进行异或操作
        int res = 0;
        for (int num : array) {
            res ^= num;
        }
        //找到不同的那一位，进行区分不同的数字
        int h = 1;
        while ((h & res) == 0) {
            h <<= 1;
        }
        //使用不同的位进行区分不同的数字
        for (int num : array) {
            if ((num & h) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        num1[0] = a;
        num2[0] = b;
    }

}
