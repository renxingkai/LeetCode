import sun.security.x509.GeneralSubtree;

public class LeetCode_204 {


    public static void main(String[] arg) {
        System.out.println(countPrimes1(10));
    }

    /**
     * 超时并且基础的算法
     *
     * @param n
     * @return
     */
    public static int countPrimes(int n) {

        int count = 0;
        for (int i = 1; i < n; i++) {
            if (isPrime(i)) {
                count++;
            }
        }
        return count;


    }

    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        if (n == 2) {
            return true;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }


    /**
     * 筛选法
     * 如果要实现筛法，需要一个O(n)的数组来存储每一个数是不是素数，暂定为true，筛选，把不是素数的定为false，最终数组里为true的就是所有的素数了。如何筛选？是素数，那么……一定不是素数。事实上，如果筛的是……那么考虑 2*3这个数，它被2筛了一次，又被3筛了一次，没有必要。可以这样筛选：对于每一个素数，筛掉……
     * 并不需要对的每一个数进行筛选，只需要对进行筛选，即可筛出所有不是素数的数。
     *
     * @param n
     * @return
     */
    public static int countPrimes1(int n) {
        boolean[] isPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            //如果已经筛选过，直接过滤掉
            if (!isPrime[i]) {
                continue;
            } else {
                for (int j = i * i; j < n; j += i) {
                    ////由于i现在是一个素数, 那么i的平方一定不是素数，i^2 + i; i^2 + 2i也一定不是素数
                    isPrime[j] = false;
                }
            }

        }
        //所有非素数均已被剔除
        for (int i = 2; i < n; i++) {
            if (isPrime[i] == true) {
                count++;
            }
        }
        return count;


    }


}
