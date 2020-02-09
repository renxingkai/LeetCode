package loadoffer;

//https://blog.csdn.net/sun_fengjiao/article/details/88173053
public class Merge {
    public static void main(String[] args) {

    }

    public ListNode Merge(ListNode list1,ListNode list2) {
        if (list1==null){
            return list2;
        }else if (list2==null){
            return list1;
        }
        ListNode list=null;
        if (list1.val<=list2.val){
            list=list1;
            list.next=Merge(list1.next,list2);
        }
        if (list1.val>list2.val){
            list=list2;
            list.next=Merge(list1,list2.next);
        }
        return list;

    }

}
