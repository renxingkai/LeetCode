import java.util.ArrayList;

public class leetcode_804 {

    public static void main(String []args){
        String []morseCode={".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        String []a={"gin","zen", "gig", "msg"};
        System.out.println(uniqueMorseRepresentations(a));
    }

    /**
     * 首先对所给的字符串数组中的各个字符串进行加密，
     * 加密后的密码直接判断是否存在于ArrayList中，如果存在的话直接continue对下一个原码字符串进行解码
     * 不存在的话，说明对计数器count+1操作，同时将该密码加入ArrayList
     * 依次判断，时间复杂度O(n^2)
     * @param words
     * @return
     */
    public static int uniqueMorseRepresentations(String[] words) {
        String []morseCode={".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        ArrayList<String> lists=new ArrayList<String>();
        int count=0;
        //遍历字符串数组
        for(int i=0;i<words.length;i++){
            String s="";
            //对原码字符串数组加密
            for(int j=0;j<words[i].length();j++){
                char c= words[i].charAt(j);
                int index=(int)c-97;
                s+=morseCode[index];
            }
            //判断加密后的字符串是否存在于lists中
            if(lists.contains(s)){
                //存在的话直接跳过此次训话
                continue;
            }else{
                //不存在计数器+1，同时将密码添加到lists中以便于对之后的密码进行判断
                lists.add(s);
                count++;
            }
        }
        return count;
    }
}
