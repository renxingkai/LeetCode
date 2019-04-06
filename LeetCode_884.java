import java.util.*;

/**
 * 既然要找出在其他句子中没出现过的单词，可以换一种思路，找出仅出现过一次的单词即可
 */
public class LeetCode_884 {

    public static void main(String[] arg) {

        String s = "apple apple";
        String a = "banana";
        System.out.println(Arrays.toString(uncommonFromSentences(s, a)));
    }

    public static String[] uncommonFromSentences(String A, String B) {
        //对A和B字符串进行以空格分割
        String[] sA = A.split(" ");
        String[] sB = B.split(" ");
        ArrayList<String> result = new ArrayList<String>();
        //保存各个字符串出现的次数
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < sA.length; i++) {
            if (map.containsKey(sA[i])) {
                map.put(sA[i], map.get(sA[i]) + 1);
            } else {
                map.put(sA[i], 1);
            }

        }
        for (int i = 0; i < sB.length; i++) {
            if (map.containsKey(sB[i])) {
                map.put(sB[i], map.get(sB[i]) + 1);
            } else {
                map.put(sB[i], 1);
            }

        }
        for (String key : map.keySet()) {
            if (map.get(key) == 1) {
                result.add(key);
            }
        }
        String []resultArr=new String[result.size()];
        for (int i=0;i<result.size();i++){
            resultArr[i]=result.get(i);
        }
        return resultArr;

    }


}
