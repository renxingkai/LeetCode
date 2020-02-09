package loadoffer;

public class ReverseSentence {

    public static void main(String[] args) {
        System.out.println(ReverseSentence("student. a am I"));
    }

    /**
     * error?
     * @param str
     * @return
     */
    public static String ReverseSentence(String str) {
        if (str.length()==0||str==null||str.length()==1){
            return str;
        }
        String[] splitStr=str.split(" ");
        String temp="";
        for (int i=0;i<splitStr.length/2;i++){
            temp=splitStr[i];
            splitStr[i]=splitStr[splitStr.length-1-i];
            splitStr[splitStr.length-1-i]=temp;
        }
        temp="";
        for (int i=0;i<splitStr.length;i++){
            temp=temp+" "+splitStr[i];
        }
        return temp;
    }


    public static String ReverseSentence2(String str) {
        if (str.trim().equals("")){
            return str;
        }
        String[] splitStr=str.split(" ");
        StringBuffer sb=new StringBuffer();
        int i;
        for (i=splitStr.length;i>0;i--){
            sb.append(splitStr[i-1]);
            if (i>1){
                sb.append(" ");
            }
        }
        return sb.toString();
    }

}
