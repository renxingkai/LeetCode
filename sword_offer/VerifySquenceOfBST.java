package loadoffer;

public class VerifySquenceOfBST {

    public static void main(String[] args) {

    }

    int root = 0;
    int index = 0;
    int max = 0;
    int min = 0;
    int count = 0;

    /**
     * 验证是否是后序遍历结果
     *
     * @param sequence
     * @return
     */
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        if (sequence.length == 1) {
            return true;
        }
        root = sequence[sequence.length - 1];//找到根节点
        for (int i = 0; i < sequence.length - 1; i++) {
            if (sequence[i] > root) {
                index = i - 1;//找到左子树的最后一个节点的位置
                if (i == 0) {
                    //只有右子树
                    for (int k = 0; k < sequence.length - 1; k++) {
                        if (sequence[k] < root) {
                            return false;
                        }
                    }
                    return true;
                }
                break;

            }
            if (max<sequence[i]){
                //找出左子树最大值
                max=sequence[i];
            }
            count++;


        }
        if (count==sequence.length-1){
            //只有左子树

            return true;
        }else {
            min=sequence[index+1];
            for (int j=index+1;j<sequence.length-1;j++){
                if (sequence[j]<root){
                    //确保右子树都大于根节点
                    return false;
                }
                if (min>sequence[j]){
                    min=sequence[j];
                }
            }
        }
        if (min>max){
            return true;
        }
        return false;

    }


}
