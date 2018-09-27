public class LeetCode_389 {

    public static void main(String[] arg) {
        System.out.println(findTheDifference("abcd", "abcde"));
    }

    /**
     * 普通遍历过不了
     * 使用数组保存每个字符串内容
     *
     * @param s
     * @param t
     * @return
     */
    public static char findTheDifference(String s, String t) {

        int[] count1 = new int[26];
        int[] count2 = new int[26];

        //保存字符串个数
        for (int i = 0; i < s.length(); i++) {
            count1[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            count2[t.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (count1[i]!=count2[i]){
                return (char)('a'+i);
            }

        }
        return 0;


    }


}
