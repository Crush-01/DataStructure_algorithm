package data_structure_offer.offer;

public class CreatListNode {
    public ListNode CreatListNodeByArray(int []array){
        ListNode node=null;
        ListNode head=null;
        if(array!=null&&array.length>0){
            node=new ListNode(array[0]);
            head=node;
            for(int i=1;i<array.length;i++){
                ListNode temp=new ListNode(array[i]);
                head.next=temp;
                head=temp;
            }
        }
        return node;
    }
}
