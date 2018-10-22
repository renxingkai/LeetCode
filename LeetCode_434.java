public class LeetCode_434 {

    public static void main(String[] arg) {
        System.out.println(countSegments("Hello, my name is John"));
    }

    //\\s表示 空格,回车,换行等空白符,
    //+号表示一个或多个的意思,
    public static int countSegments(String s) {
        if(s.trim().length()==0||s==null){
            return 0;
        }
        return s.trim().split("\\s+").length;

    }

}






