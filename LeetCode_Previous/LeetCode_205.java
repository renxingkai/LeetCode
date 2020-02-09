import java.util.HashMap;

/**
 * 采用映射的方法来解答
 */
public class LeetCode_205 {

    public static void main(String[] arg) {
        System.out.println(isIsomorphic("paper", "title"));
    }

    public static boolean isIsomorphic(String s, String t) {
        if (s==null||t==null){
            //如果为空直接返回false
            return false;
        }
        HashMap<Character,Character> hashMap=new HashMap<Character, Character>();
        for(int i=0;i<s.length();i++){
            char ss=s.charAt(i);
            char tt=t.charAt(i);
            if (hashMap.containsKey(ss)){
                //先判断是否包含ss
                if (hashMap.get(ss)==tt){
                    //获取ss对应的值，如果为tt，则映射成功，继续
                    continue;
                }else {
                    //获取ss对应的值，如果不为tt，说明映射不成功，直接返回fales
                    return false;
                }
            }else {
                if (hashMap.containsValue(tt)){
                    //如果hashMap含有值tt,但是此时hashMap没有键ss(键为空)
                    //返回False
                    return false;
                }else {
                    //如果均不含ss和tt，则添加这两个到hashMap
                    hashMap.put(ss, tt);
                }
            }
        }
        return true;
    }
}
