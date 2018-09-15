import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LeetCode_290 {

    public static void main(String[] arg) {
        System.out.println(wordPattern("abba", "dog dog dog dog"));
    }

    /**
        使用Map的映射方式来做，如果map不含key则将key-value添加
     如果包含key，则去判断key对应的value是否为str[i]
     */
    public static boolean wordPattern(String pattern, String str) {
        int size = str.split(" ").length;
        String[] arrStr = new String[size];
        arrStr = str.split(" ");
        boolean flag = true;
        Map<Character, String> hashMap = new HashMap<>();
        if (size != pattern.length()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!hashMap.containsKey(pattern.trim().charAt(i))) {
                //判断如果map中不含某个键a，但是包含了值b，则直接返回false
                if (hashMap.containsValue(arrStr[i])) {
                    flag = false;
                    break;
                }
                hashMap.put(pattern.charAt(i), arrStr[i]);
            } else {
                //如果包含key，则去判断key对应的value是否为str[i]
                if (!hashMap.get(pattern.charAt(i)).equals(arrStr[i])) {
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }


}
