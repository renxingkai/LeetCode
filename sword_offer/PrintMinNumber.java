package loadoffer;

public class PrintMinNumber {

    public static void main(String[] args) {

    }

    //    在这里自定义一个比较大小的函数，
    //    比较两个字符串s1, s2大小的时候，先将它们拼接起来，比较s1+s2,和s2+s1那个大，
    //    如果s1+s2大，那说明s2应该放前面，所以按这个规则，s2就应该排在s1前面。
    public String PrintMinNumber(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                int a = Integer.valueOf("" + numbers[i] + numbers[j]);
                int b = Integer.valueOf("" + numbers[j] + numbers[i]);
                if (a > b) {
                    int temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }
        String str = "";
        for (int i = 0; i < numbers.length; i++) {
            str += numbers[i];
        }
        return str;
    }


}
