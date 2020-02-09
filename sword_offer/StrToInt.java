package loadoffer;

public class StrToInt {

    public static void main(String[] args) {

    }

    public int StrToInt(String str) {
        if (str.length() == 0 || str.equals("")) return 0;
        char[] charArray = str.toCharArray();
        int start = 0;
        boolean flag = true;
        if (charArray[0] == '-' || charArray[0] == '+') {
            start = 1;
            if (charArray[0] == '-') {
                flag = false;
            }
        }
        int sum = 0;//返回结果
        for (int i = start; i < charArray.length; i++) {
            if (charArray[i] < 48 || charArray[i] > 57) {
                return 0;
            } else {
                sum = sum * 10 + (charArray[i] - 48);
            }

        }
        return flag ? sum : -1*sum;
    }

}
