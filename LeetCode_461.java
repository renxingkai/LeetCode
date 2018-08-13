

public class LeetCode_461 {

    public static void main(String[]arg){
        System.out.println(hammingDistance(1,4 ));
    }

    /**
     * 将x和y异或完之后，结果中含有的1的个数即为hammingDistance
     * 使用Integer自带的转2进制方法Integer.toBinaryString()将x^y转为二进制字符串
     * 然后对转为的字符串进行遍历，统计1的个数，最后返回
     * @param x
     * @param y
     * @return
     */
    public static int hammingDistance(int x, int y) {
        int count=0;
        //将x和y异或
        int result=x^y;
        //使用Integer自带的转2进制方法Integer.toBinaryString()将x^y转为二进制字符串
        String s=Integer.toBinaryString(result);
        //对转为的字符串进行遍历，统计1的个数，最后返回
        for (int i=0;i<s.length();i++){
            if (s.charAt(i)=='1'){
                count++;
            }
        }
        return count;
    }

}
