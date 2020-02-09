public class LeetCode_344 {

    public static void main(String[]arg){
        System.out.println(reverseString("A man, a plan, a canal: Panama"));
    }


    public static String reverseString(String s) {
        StringBuffer sb=new StringBuffer(s);
        return sb.reverse().toString();
    }

}
