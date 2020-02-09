public class LeetCode_682 {

    public static void main(String[] arg) {

    }

    public int calPoints(String[] ops) {
        if (ops.length == 0) {
            return 0;
        }
        int[] num = new int[ops.length];
        int index = 0;
        for (int i = 0; i < ops.length; i++) {
            char ch = ops[i].toCharArray()[0];
            switch (ch) {
                case '+':
                    //两数求和
                    int numTemp = num[index - 1] + num[index - 2];
                    num[index++] = numTemp;
                    break;
                case 'D':
                    //double
                    int numTempD = num[index - 1] * 2;
                    num[index++] = numTempD;
                    break;
                case 'C':
                    //清空上一个数
                    num[--index] = 0;
                    break;
                default:
                    num[index++] = Integer.parseInt(ops[i]);
                    break;
            }

        }
        int count = 0;
        for (int i = 0; i < num.length; i++) {
            count += num[i];
        }
        return count;
    }

}
