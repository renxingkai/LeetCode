package leetcode_771;

/*
此题的题意为给定字符串J为含有宝石的字符串，J中每个字符都可以成为一个宝石，S字符串是普通给定的石头，要查找出S中含有宝石的个数，即含有J中字符的个数，提示中说明J中字符均不相同，同时区分大小写。

解题思路：

直接遍历字符串S中的每个字符，同时判断如果该字符在J中出现，则S中含有宝石的数量+1，遍历完S后，即可得到结果，并将结果返回。
*/

public class LeetCode_771 {

    public static void main(String[] args) {

        System.out.println(numJewelsInStones("aA", "aAAbbbb"));

    }


    public static int numJewelsInStones(String J, String S) {
//      统计出现的次数
        int count=0;
//      将S遍历每个字符，查看String J中是否含有S的字符
        for(int i=0;i<S.length();i++){
            char c=S.charAt(i);
            String c1=String.valueOf(c);
            if(J.contains(c1)){
//              含有的话数量+1
                count++;
            }
        }
        return count;
    }
}
