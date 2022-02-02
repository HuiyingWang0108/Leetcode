public class DeleteDuplicates {
    public static void main(String[] args) {
        DeleteDuplicates obj = new DeleteDuplicates();
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);

        obj.deleteDuplicates(head);
    }

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode curr = new ListNode();
        curr = head;
        while(curr.next != null){
           if(curr.val == curr.next.val){
               curr.next = curr.next.next;
           }else{
               curr = curr.next;
           }
        }
        return head;
    }
}