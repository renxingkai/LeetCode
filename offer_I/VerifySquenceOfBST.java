package offer_I;

public class VerifySquenceOfBST {

    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        return helper(sequence, 0, sequence.length - 1);
    }

    private boolean helper(int[] sequence, int start, int end) {
        if (start >= end) {
            return true;
        }
        //找出根
        int rootValue = sequence[end];
        //找出右子树
        int i = start;
        for (; i < end; i++) {
            if (sequence[i] > rootValue) {
                break;
            }
        }
        //此时，i就是右子树
        int j;
        for (j = i; j < end; j++) {
            if (sequence[j] < rootValue) {
                return false;
            }
        }
        return helper(sequence, start, i - 1) && helper(sequence, i + 1, end);
    }
}
