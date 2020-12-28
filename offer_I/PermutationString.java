package offer_I;

import java.util.ArrayList;
import java.util.Collections;

public class PermutationString {
    public static void main(String[] args) {

    }

    ArrayList<String> res = new ArrayList<>();

    public ArrayList<String> Permutation(String str) {
        if ("".equals(str)) {
            return res;
        }
        recurr(str.toCharArray(), 0, res);
        Collections.sort(res);
        return res;
    }

    private void recurr(char[] toCharArray, int i, ArrayList<String> res) {
        if (i == toCharArray.length - 1) {
            if (!res.contains(String.valueOf(toCharArray))) {
                res.add(String.valueOf(toCharArray));
            }
        }else {
            for (int j = i; j < toCharArray.length; j++) {
                swap(toCharArray, i, j);
                recurr(toCharArray, i + 1, res);
                //回溯
                swap(toCharArray, i, j);
            }
        }
    }

    private void swap(char[] toCharArray, int i, int j) {
        char temp = toCharArray[i];
        toCharArray[i] = toCharArray[j];
        toCharArray[j] = temp;
    }
}
