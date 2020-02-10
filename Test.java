package data_structure_offer;

public class Test {
    public static void main(String[] args) {
        int []a={1,3,5,7,9};
        int []b={2,4,6,8,10};
        CreatListNode creat=new CreatListNode();
        ListNode list1=creat.CreatListNodeByArray(a);
        ListNode list2=creat.CreatListNodeByArray(b);
        MergeTwoListNode merge=new MergeTwoListNode();
        ListNode node=merge.Merge(list1,list2);
        while(node!=null){
            System.out.println(node.val);
            node=node.next;
        }
    }
}
