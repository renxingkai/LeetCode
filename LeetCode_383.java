import javax.swing.*;

public class LeetCode_383 {


    public static void main(String[] arg) {

    }

    /**
     * 方法一：
     * 这种解法比较简单，就是将ransomNote的字符串挨个遍历，每个字符再从magazine里遍历匹配，只是再创建了个byte数组，
     * 数组每个元素的索引表示magazine字符串的位置，元素值表示是否被校验过，0表示还未被校验过，非0就表示该位置已经被校验过。不过这种做法效率不高。
     *
     * @param ransomNote
     * @param magazine
     * @return
     */
    public static boolean canConstruct(String ransomNote, String magazine) {
        boolean ret = true;
        byte[] bytes = new byte[magazine.length()];
        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            boolean found = false;
            for (int j = 0; j < magazine.length(); j++) {
                if (bytes[j] == 0 && magazine.charAt(j) == c) {
                    bytes[j]++;
                    found = true;
                    break;
                }
            }
            if (!found) {
                ret = false;
                break;
            }
        }
        return ret;
    }


    /**
     * 方法三：这是LeetCode Discuss中的最热代码，它的原理就是列出了magazine的字母表，然后算出了出现个数，
     * 然后遍历ransomNote，保证有足够的字母可用，代码非常清晰。
     *
     * @param ransomNote
     * @param magazine
     * @return
     */
    public static boolean canConstruct1(String ransomNote, String magazine) {
        int[] arr = new int[26];
        //构建字典表
        for (int i = 0; i < magazine.length(); i++) {
            arr[magazine.charAt(i) - 'a']++;
        }
        //将ransomNote中的字符取出，依次比较字典表中对应的值是否<0
        for (int i = 0; i < ransomNote.length(); i++) {
            if (--arr[ransomNote.charAt(i)-'a'] < 0) {
                //如果小于0，则说明无法通过magazine构建ransomNote
                return false;
            }
        }
        return true;
    }


}
