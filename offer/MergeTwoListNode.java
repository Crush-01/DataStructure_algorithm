package data_structure_offer.offer;
//输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。

//递归方法
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
//    非递归的方法
    public ListNode Merge2(ListNode list1,ListNode list2){
        ListNode head=new ListNode(-1);//用于合并链表的节点（指针）
        ListNode root=head;//root.next为最后返回的节点，而head去修改next的指向。即一个作为结果，一个操作
        while(list1!=null&&list2!=null){
            if(list1.val<=list2.val){
                head.next=list1;//如果改变顺序
                head=list1;     //会发生list1指向自己的情况
                list1=list1.next;
            }else{
                head.next=list2;
                head=list2;
                list2=list2.next;
            }
        }
        if(list1!=null){
            head.next=list1;
        }
        if(list2!=null){
            head.next=list2;
        }
        return root.next;
    }
    public static void main(String[] args) {
        MergeTwoListNode merge=new MergeTwoListNode();
        CreatListNode creat=new CreatListNode();
        int a1[]={3,5,7,9};
        int a2[]={4,6,8,10};
        ListNode list1=creat.CreatListNodeByArray(a1);
        ListNode list2=creat.CreatListNodeByArray(a2);
        ListNode node=merge.Merge2(list1,list2);
        while(node!=null){
            System.out.println(node.val);
            node=node.next;
        }
    }
}
