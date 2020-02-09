package loadoffer;

public class ReOrderArray {

    public static void main(String[] args) {

    }

    //    https://blog.csdn.net/zhangshk_/article/details/81190870
    public void reOrderArray2(int[] array) {
        int i = 0;
        int j = array.length - 1;
        int temp = 0;
        while (i < j) {
            if ((array[i] & 1) == 1) {
                //奇数
                i++;
                continue;
            }
            if ((array[i] & 1) == 0) {
                j--;
                continue;
            }
            temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            i++;
            j--;
        }

    }

    /**
     * 1.从左到右遍历数组中的每一个值,该值与下一个值依次对2求余比较。
     * 2.余数为1则为奇数,余数为0则为偶数。
     * 3.如果该值对2求余大于下一个值对2求余的数,则前为奇,后为偶,直接跳出本次循环,继续下一次循环。
     * 4.如果该值对2求余等于下一个值对2求余的数,则两值或都为奇数,或都为偶数,也直接跳出本次循环,继续下一次循环。
     * 5.如果该值对2求余小于下一个值对2求余的数,则前为偶,后为奇,两者置换,并且要进行前一次循环(因为不确定前一次循环的值是奇数还是偶数)
     * 6.回退后可能发生i<0的情况，则重新将i置为0。
     *
     * @param array
     */
    public void reOrderArray(int[] array) {
        int temp=0;
        int i=0;
        while (i<array.length-1){
            if (array[i]%2>=array[i+1]%2){
                i++;
                continue;
            }else {
                temp=array[i];
                array[i]=array[i+1];
                array[i+1]=temp;
                i--;
                if (i<0){
                    i=0;
                }
            }
        }


    }

}
