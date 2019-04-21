public class LeetCode_748 {

    public static void main(String[] arg) {
        String[] words = new String[]{"step", "steps", "stripe", "stepple"};
        String s = "1s3 PSt";
        LeetCode_748 leetCode_748=new LeetCode_748();
        leetCode_748.shortestCompletingWord(s, words);
    }

    public String shortestCompletingWord(String licensePlate, String[] words) {
        int minLen = Integer.MAX_VALUE;
        int idx = -1;
        //对licensePlate进行标准化
        String standardPlate = normalizePlate(licensePlate);
        //遍历每个单词去查看是否匹配
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() < minLen && isGoodMatch(standardPlate, words[i])) {
                minLen = words[i].length();
                idx = i;
            }
        }
        if (idx == -1) {
            return "you are lying!";
        }

        return words[idx];

    }

    private boolean isGoodMatch(String standardPlate, String word) {

        if (standardPlate.length() > word.length()) {
            //如果模板比单词长度长，则不会匹配
            return false;
        }
        int[] letters = new int[26];
        for (int i = 0; i < word.length(); i++) {
            //索引添加元素
            letters[word.charAt(i) - 'a']++;
        }

        for (int j = 0; j < standardPlate.length(); j++) {
            if (letters[standardPlate.charAt(j) - 'a'] == 0) {
                return false;
            }
            letters[standardPlate.charAt(j) - 'a']--;
        }
        return true;

    }

    /**
     * 标准化licensePlate
     *
     * @param licensePlate
     * @return
     */
    private String normalizePlate(String licensePlate) {
        StringBuilder builder = new StringBuilder(licensePlate.length());
        for (int i = 0; i < licensePlate.length(); i++) {
            if (licensePlate.charAt(i) >= 'A' && licensePlate.charAt(i) <= 'z') {
                //同时取A-Z和a-z
                builder.append(Character.toLowerCase(licensePlate.charAt(i)));
            }
        }
        return builder.toString();
    }


}
