package offer_I;

import netscape.security.UserTarget;

public class ReplaceSpace {


    /**
     * 替换空格
     * @param str
     * @return
     */
    public String replaceSpace(StringBuffer str) {
        StringBuilder stringBuilder=new StringBuilder();
        for (int i=0;i<str.length();i++){
            if (str.charAt(i)==' '){
                stringBuilder.append("%20");
            }else {
                stringBuilder.append(str.charAt(i));
            }
        }
        return stringBuilder.toString();
    }

}
