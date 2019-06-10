import java.util.ArrayList;
import java.util.Arrays;

public class LeetCode_1078 {


    public static void main(String[] arg) {
        System.out.println(Arrays.toString(findOcurrences("alice is a good girl she is a good student", "a", "good")));
    }

    public static String[] findOcurrences(String text, String first, String second) {
        String[] texts = text.split(" ");
        ArrayList<String> temp = new ArrayList<String>();
        int count = 0;

        for (int i = 0; i < texts.length - 2; i++) {
            if (first.trim().equals(texts[i].trim()) && second.trim().equals(texts[i + 1].trim())) {
                count++;
                temp.add(texts[i + 2]);
            }
        }
        String[] results = new String[count];
        for (int i = 0; i < temp.size(); i++) {
            results[i] = temp.get(i);
        }
        return results;
    }


}
