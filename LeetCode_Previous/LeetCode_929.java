import java.util.HashSet;
import java.util.Set;

public class LeetCode_929 {


    public static void main(String[] arg) {

    }

    //https://leetcode.com/problems/unique-email-addresses/discuss/281679/java-solution-20ms-with-HashSet
    public int numUniqueEmails(String[] emails) {
        Set<String> seen = new HashSet<>();
        for (String email : emails) {
            String[] splitEmail = email.split("@");
            String newName = (splitEmail[0].indexOf("+") == -1 ? splitEmail[0] : splitEmail[0].substring(0, splitEmail[0].indexOf('+'))).replace(".", "") + "@" + splitEmail[1];
            //使用hashset去重
            seen.add(newName);
        }
        return seen.size();
    }

}
