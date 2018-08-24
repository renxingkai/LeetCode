/**
 * 将原字符串以空格切分，然后遍历切分后的数组，对每个数组中的元素（单词）进行逆序并相拼接，注意返回逆序字符串空格的输出
 */
public class LeetCode_557 {

    public static void main(String []arg){
        System.out.println(reverseWords("Let's take LeetCode contest"));
    }

    public static String reverseWords(String s) {
        //将原字符串以空格切分
        String []ss=s.split(" ");
        String res="";
        //遍历切分后的数组
        for(int i=0;i<ss.length;i++){
            //对每个数组中的元素（单词）进行逆序并相拼接
            StringBuffer re=new StringBuffer(ss[i]);
            res+=re.reverse().toString();
            //注意返回逆序字符串空格的输出
            if (i!=ss.length-1){
                res+=" ";
            }
        }
        return res;
    }

}
