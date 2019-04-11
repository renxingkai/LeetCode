public class LeetCode_1009 {


    public static void main(String[] arg) {
        System.out.println(bitwiseComplement(10));
    }

    //正常思维 转为二进制，取反，拼接
    public static int bitwiseComplement(int N) {
        if (N == 0) {
            return 1;
        }
        String originalBinary = Integer.toBinaryString(N);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < originalBinary.length(); i++) {
            if (originalBinary.charAt(i) == '0') {
                sb.append('1');
            } else {
                sb.append('0');
            }
        }
        String result = sb.toString();
        return (Integer.parseInt(result, 2));
    }


}
