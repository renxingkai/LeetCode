import java.math.BigInteger;

public class LeetCode_476 {

    public static void main(String []arg){
        System.out.println(findComplement(0));
    }

    /**
     * 将十进制转为二进制，然后遍历二进制的各个位数，如果遇到1则转为0，如果遇到0则转为1
     * 然后将转换后的数字合并为字符串，再转为十进制之后进行返回
     * @param num
     * @return
     */
    public static int findComplement(int num) {
        if (num==1){
            return 0;
        }
        if (num==0){
            return 1;
        }
        //转换为二进制
        String binaryString=Integer.toBinaryString(num);
        String reversed="";
        //遍历二进制的各个位数，如果遇到1则转为0，如果遇到0则转为1
        for(int i=0;i<binaryString.length();i++){
            if (binaryString.charAt(i)=='0'){
                reversed+="1";
            }else {
                reversed+="0";
            }
        }
        //将二进制转为十进制
        BigInteger bigInteger=new BigInteger(reversed.trim(),2);
        int reversedDecimal=Integer.parseInt(bigInteger.toString());
        return reversedDecimal;


    }


}
