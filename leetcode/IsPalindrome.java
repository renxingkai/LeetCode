package leetcode;

public class IsPalindrome {


    public static void main(String[] args) {

    }

    /**
     * 两个指针，如果不相等，直接返回false
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        if (s==null){
            return true;
        }
        s=s.toLowerCase();
        int l=0;
        int r=s.length()-1;
        while (l<r){
            if (!Character.isLetterOrDigit(s.charAt(r))){
                //右指针移动
                r--;
            } else if (!Character.isLetterOrDigit(s.charAt(l))) {
                l++;
            }else {
                if (s.charAt(r)!=s.charAt(l)){
                    return false;
                }
                l++;
                r--;
            }
        }
        return true;
    }


}
