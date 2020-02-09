public class LeetCode_242 {

    public static void main(String[] arg) {

    }
    //两个int型数组，sArray和tArray，来储存s和t字符串中的字符情况，a对应数组下标0，b对应数组下标1……
    //
    //最后比较两个数组内容情况。
    //
    //也可以用哈希表实现。原理一样。
    public boolean isAnagram(String s, String t) {
        if (s.length()!=t.length()){
            return false;
        }else {
            int []sArray=new int[26];
            int []tArray=new int[26];
            //建立索引表
            for (int i=0;i<s.length();i++){
                sArray[s.charAt(i)-97]++;
                tArray[t.charAt(i)-97]++;
            }
            //比较两个索引表
            for (int i=0;i<26;i++){
                if (sArray[i]!=tArray[i]){
                    return false;
                }
            }
            return true;
        }
    }
}
