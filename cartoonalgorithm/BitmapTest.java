package cartoonalgorithm;

/**
 * 使用bitmap去保存用户画像
 */
public class BitmapTest {
    //每一个word是一个long类型元素，对应一个64位二进制数据
    private long[] words;
    //Bitmap位数大小
    private int size;

    public BitmapTest(int size) {
        this.size = size;
        this.words = new long[getwordIndex(size - 1) + 1];
    }

    /**
     * 判断Bitmap某一位的状态
     *
     * @param bitIndex
     * @return
     */
    public boolean getBit(int bitIndex) {
        if (bitIndex < 0 || bitIndex > size - 1) {
            throw new IndexOutOfBoundsException("越界");
        }
        int wordIndex = getwordIndex(bitIndex);
        return (words[wordIndex] & (1L << bitIndex)) != 0;
    }


    /**
     * 设置bitmap某一位为true
     * @param bitIndex
     */
    public void setBit(int bitIndex) {
        if (bitIndex < 0 || bitIndex > size - 1) {
            throw new IndexOutOfBoundsException("越界");
        }
        int wordIndex = getwordIndex(bitIndex);
        words[wordIndex] |= (1L << bitIndex);
    }

    /**
     * 定位bitmap某一位所对应的word
     *
     * @param i bitmap的第i位
     * @return
     */
    private int getwordIndex(int i) {
        //相当于除以64
        return i >> 6;
    }

}
