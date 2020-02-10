package data_structure_offer;
//输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
public class MergeTwoListNode {
    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode flag=null;
        while(list1!=null&&list2!=null){
            if(list1.val<=list2.val){
                if(list1.next!=null){
                    if(list1.next.val>=list2.val){
                        list2.next=list1.next;
                    }
                }
                list1.next=list2;
            }else{
                flag=list2;
            }
            list1=list1.next;
            list2=list2.next;
        }
        if(flag!=null){
            flag.next=list1;
            return flag;
        }
        return list1;
    }
}
