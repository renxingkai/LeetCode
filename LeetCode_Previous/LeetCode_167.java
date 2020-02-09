/**
 * 使用双指针来进行标记并计算
 *      左指针从小的元素开始移动向大的元素，右指针从大的元素开始移动向小的元素
 *      计算两个指针对应元素的和sum，如果sum<target，则将小指针往右移动
 *                               如果sum>target，则将大指针往左移动
 *                               如果sum=target，则返回两个指针对应的索引
 */
public class LeetCode_167 {

    public static void main(String[] arg) {

    }


    public int[] twoSum(int[] numbers, int target) {
        //定义左右指针
        int left=0;
        int right=numbers.length-1;
        int []result=new int[2];
        while (left<right){
            if (numbers[left]+numbers[right]<target){
                //如果sum<target，则将小指针往右移动
                left++;
                continue;
            }else if (numbers[left]+numbers[right]>target){
                //如果sum>target，则将大指针往左移动
                right--;
                continue;
            }else {
                //如果sum=target，则返回两个指针对应的索引
                result[0]=left+1;
                result[1]=right+1;
                break;
            }
        }
        return result;
    }

}
