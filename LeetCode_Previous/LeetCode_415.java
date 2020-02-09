import java.math.BigInteger;

public class LeetCode_415 {

    public static void main(String[] arg) {
        System.out.println(addStrings("1234546", "123344"));
    }

    public static String addStrings(String num1, String num2) {
        BigInteger bigInteger1=new BigInteger(num1);
        BigInteger bigInteger2=new BigInteger(num2);
        return String.valueOf(bigInteger1.add(bigInteger2));
    }
}
