import javax.swing.text.html.HTMLDocument;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class LeetCode_387 {


    public static void main(String[] arg) {
        System.out.println(firstUniqChar("dddccdbba"));
    }

    /**
     * 放到hashMap中进行存储，最后找到只出现一次的元素值对应的索引
     * @param s
     * @return
     */
    public static int firstUniqChar(String s) {
        if (s==""){
            return -1;
        }
        LinkedHashMap<Character, Integer> hashMap = new LinkedHashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if (!hashMap.containsKey(ch)) {
                hashMap.put(ch, 1);
            } else {
                hashMap.put(ch, hashMap.get(ch) + 1);
            }
        }

        for (int i = 0; i < s.length(); i++) {
            if (hashMap.get(s.charAt(i))==1){
                return i;
            }
        }


        return -1;


    }


}
