import java.lang.reflect.Array;
import java.nio.MappedByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class LeetCode_937 {

    //https://blog.csdn.net/iwts_24/article/details/83990375

    /**
     *   题目很长，总之，就是给出一个字符串数组，每条字符串由空格分开，第一个空格前的子串是日志的标识符。而后面的就是日志的具体内容。日志的内容一定是2种情况：全为小写字母或者全为数字。现在要求对其排序，要求总结如下：
     * <p>
     * 1.不包括标识符，也就是说排序以日志内容为准，在忽略标识符的前提下进行排序。
     * <p>
     * 2.对于小写字母的日志，按照字典序进行排序。
     * <p>
     * 3.对于数字的日志，不排序，但是全部放在字母日志的后面。顺序是在数组中出现的顺序。
     * ---------------------
     *
     * @param arg
     */
    public static void main(String[] arg) {

    }

    public String[] reorderLogFiles(String[] logs) {
        HashMap<String, String> map = new HashMap<String, String>();
        ArrayList<String> arr = new ArrayList<String>();
        ArrayList<String> arrNum = new ArrayList<String>();
        for (int i = 0; i < logs.length; i++) {
            for (int j = 0; j < logs[i].length(); j++) {
                if (logs[i].charAt(j) == ' ') {
                    String flag = logs[i].substring(0, j);
                    String key = logs[i].substring(j + 1, logs[i].length());
                    if (key.charAt(0) >= '0' && key.charAt(0) <= '9') {
                        arrNum.add(key);
                    } else {
                        arr.add(key);
                    }
                    map.put(key, flag);
                    break;
                }
            }
        }
        //对数组进行排序,仅对字母log进行排序
        Collections.sort(arr);
        String[] ans = new String[logs.length];
        int i = 0;
        //添加字符数组
        for (i = 0; i < arr.size(); i++) {
            String value = arr.get(i);
            StringBuilder sb = new StringBuilder(map.get(value));
            sb.append(" " + value);
            ans[i] = sb.toString();
        }
        //添加数字数组
        for (int j = 0; j < arrNum.size(); j++, i++) {
            String value = arrNum.get(j);
            StringBuilder sb = new StringBuilder(map.get(value));
            sb.append(" " + value);
            ans[i] = sb.toString();
        }
        return ans;
    }
}
