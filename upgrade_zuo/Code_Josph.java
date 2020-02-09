package upgrade_zuo;

/**
 * O(N) 约瑟夫四环
 * 编号=(报数-1)%i+1   长度为i时候
 * <p>
 * 旧编号=(新编号-1+S)%i+1
 * S是被杀掉的节点
 * S=(m-1)%i+1
 * <p>
 * 旧编号=(新编号+m-1)%i+1
 */
public class Code_Josph {

    /**
     * 长度为i，报道m就杀人的情况
     *
     * @param i
     * @param m
     * @return
     */
    public static int getLive(int i, int m) {
        if (i == 1) {
            return 1;
        }
        return (getLive(i - 1, m) + m - 1) % i + 1;
    }

}
