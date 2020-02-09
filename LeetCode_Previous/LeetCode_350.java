import java.util.ArrayList;
import java.util.Arrays;

/**
 * Intersection of Two Arrays II
 */
public class LeetCode_350 {


    public static void main(String[] arg) {

    }

    /**
     * 对两个数组分别进行排序，然后用两个指针索引，分别对应两个数组，依次变动索引，
     * 如果索引对应的元素相等则对元素进行保存，如果不相等则先移动索引元素比较小的元素对应的指针
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> resultArr = new ArrayList<Integer>();
        //对两个数组进行排序
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        for (int i = 0, j = 0; i < nums1.length && j < nums2.length; ) {
            if (nums1[i] == nums2[j]) {
                //如果两个元素相等，则添加到结果集，并且i++,j++
                resultArr.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                //如果nums1[i]< nums2[j]，则只对nums1[i]（小的元素）对应的索引+1
                i++;
            } else {
                //如果nums2[j]< nums1[i]，则只对nums2[j]（小的元素）对应的索引+1
                j++;
            }
        }

        int[] result = new int[resultArr.size()];
        //遍历ArrayList，返回数组
        for (int i = 0; i < resultArr.size(); i++) {
            result[i] = resultArr.get(i);
        }
        return result;
    }

}
