package loadoffer;
//https://blog.csdn.net/u011444062/article/details/78768808
public class CharAppearOnce {
    String str="";
    int []count=new int[256];
    //Insert one char from stringstream
    public void Insert(char ch)
    {
        if (ch>256){
            return;
        }else {
            str+=ch;
            count[ch]++;
        }


    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        for (char c:str.toCharArray()){
            if (count[c]==1){
                return c;
            }
        }
        return '#';
    }
}
