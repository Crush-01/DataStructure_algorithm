package data_structure_offer.offer;
//输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
public class MergeTwoListNode {
    public ListNode Merge(ListNode list1,ListNode list2) {
//        if(list1 == null){
//            return list2;
//        }
//        if(list2 == null){
//            return list1;
//        }
//        if(list1.val <= list2.val){
//            list1.next = Merge(list1.next, list2);
//            return list1;
//        }else{
//            list2.next = Merge(list1, list2.next);
//            return list2;
//        }
        if(list1==null)
            return list2;
        if(list2==null)
            return list1;
        ListNode res = null;
        if(list1.val<list2.val){
            res = list1;
            res.next = Merge(list1.next, list2);
        }else{
            res = list2;
            res.next = Merge(list1, list2.next);
        }
        return res;

    }

    public static void main(String[] args) {
        MergeTwoListNode merge=new MergeTwoListNode();
        CreatListNode creat=new CreatListNode();
        int a1[]={3,5,7,9};
        int a2[]={4,6,8,10};
        ListNode list1=creat.CreatListNodeByArray(a1);
        ListNode list2=creat.CreatListNodeByArray(a2);
        ListNode node=merge.Merge(list1,list2);
        while(node!=null){
            System.out.println(node.val);
            node=node.next;
        }
    }
}
