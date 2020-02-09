package loadoffer;

public class Duplicate {


    public static void main(String[] args) {

    }


    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    public boolean duplicate(int numbers[], int length, int[] duplication) {
        if (length == 0 || numbers == null) {
            return false;
        }
        //转换为字符串
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            stringBuilder.append(numbers[i]);
        }
        int num = 0;
        //依次的拿出每个值，查看它是否有重复值 ，有的话就记录下来，记住只拿第一个重复的，
        //而不是最后的重复的，因为重复记录的数组只有一个空
        for (int i = 0; i < stringBuilder.length(); i++) {
            String ch = String.valueOf(stringBuilder.charAt(i));
            int a = stringBuilder.indexOf(ch);
            int b = stringBuilder.lastIndexOf(ch);
            if (a != b) {
                duplication[0] = Integer.parseInt(ch);
                break;
            }
            num++;//记录重复值，有的话一定比length小，大的话一定不存在重复值
        }
        if (num < length) {
            return true;
        }
        if (num >= length) {
            return false;
        }
        return false;
    }
}
