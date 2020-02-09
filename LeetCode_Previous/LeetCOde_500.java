
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class LeetCOde_500 {


    public static void main(String[] arg) {
        String[] strings = new String[]{"Hello", "Alaska", "Dad", "Peace"};
        System.out.println(Arrays.toString(findWords(strings)));
    }

    /*public static String[] findWords(String[] words) {
        String s1 = "qwertyuiop";
        String s2 = "asdfghjkl";
        String s3 = "zxcvbnm";
        List<String> arr = new ArrayList<String>();
        for (int i = 0; i < words.length; i++) {
            String temp = words[i].toLowerCase();
            Set<Character> set = new HashSet<Character>();
            for (int j = 0; j < temp.length(); j++) {
                set.add(temp.charAt(j));
            }
            String ss = "";
            for (Character str : set) {
                ss += str;

            }
            for (int k=0;k<ss.length();k++){

            }
            if (s3.contains(ss.trim())) {
                arr.add(words[i]);
            } else if (s2.contains(ss.trim())) {
                arr.add(words[i]);
            } else if (s1.contains(ss.trim())) {
                arr.add(words[i]);
            }
        }

        String[] res = new String[arr.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = arr.get(i);
        }
        return res;

    }*/

    /**
     * 放到map中进行判断
     *
     * @param words
     * @return
     */
    public static String[] findWords(String[] words) {

        String s1 = "qwertyuiopQWERTYUIOP";
        String s2 = "asdfghjklASDFGHJKL";
        String s3 = "zxcvbnmZXCVBNM";
        HashMap<Character, Integer> hashMap1 = new HashMap<Character, Integer>();
        HashMap<Character, Integer> hashMap2 = new HashMap<Character, Integer>();
        HashMap<Character, Integer> hashMap3 = new HashMap<Character, Integer>();
        for (char c : s1.toCharArray()) {
            hashMap1.put(c, 1);
        }
        for (char c : s2.toCharArray()) {
            hashMap2.put(c, 1);
        }
        for (char c : s3.toCharArray()) {
            hashMap3.put(c, 1);
        }

        int i = 0;
        for (String s : words) {
            if (isTrue(s, hashMap1) || isTrue(s, hashMap2) || isTrue(s, hashMap3)) {
                words[i] = s;
                i++;
            }
        }
        return Arrays.copyOfRange(words, 0, i);


    }


    public static boolean isTrue(String s, HashMap<Character, Integer> map) {
        for (char c : s.toCharArray()) {
            if (!map.containsKey(c)) {
                return false;
            }
        }
        return true;
    }

}
