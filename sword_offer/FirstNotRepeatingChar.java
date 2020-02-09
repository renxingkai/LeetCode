package loadoffer;

import java.util.HashMap;

public class FirstNotRepeatingChar {

    public static void main(String[] args) {

    }

    public int FirstNotRepeatingChar(String str) {
        if (str==null||str.length()==0){
            return -1;
        }
        HashMap<Character,Integer> result=new HashMap<Character, Integer>();
        for (int i=0;i<str.length();i++){
            if (result.containsKey(str.charAt(i))){
                result.put(str.charAt(i),result.get(str.charAt(i))+1);
            }else {
                result.put(str.charAt(i),1);
            }
        }
        for (int i=0;i<str.length();i++){
            if (result.get(str.charAt(i))==1){
                return i;
            }
        }
        return -1;
    }


}
