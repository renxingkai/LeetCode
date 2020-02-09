package leetcode;

public class Merge {

    public static void main(String[] args) {

    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        for (int s1 = nums1.length - 1; s1 >= 0; s1--) {
            if (i<0||(j>=0&&nums2[j]>nums1[i])){
                nums1[s1]=nums2[j--];
            }else if (j<0||(i>=0&&nums1[i]>=nums2[j])){
                nums1[s1]=nums1[i--];
            }
        }
    }

}
