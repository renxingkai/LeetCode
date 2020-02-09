public class LeetCode_509 {


    public static void main(String[] arg) {
        System.out.println(fib(2));
    }

    public static int fib(int N) {
        int a = 0;
        int b = 1;
        if (N == 0) {
            return 0;
        } else if (N == 1) {
            return a + b;
        } else {
            int result = 0;
            for (int i = 0; i < N; i++) {

                a = b;
                b = result;
                result = a + b;

            }
            return result;
        }

    }


}







