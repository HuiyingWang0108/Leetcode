public class RemoveElements{
    public static void main(String[] args){
        RemoveElements obj = new RemoveElements();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(6);
        int val = 6;
        ListNode l = obj.removeElements(head, val);

    }
    public ListNode removeElements(ListNode head, int val) {
        if(head != null){
            while(head.val == val){
                head = head.next;
                if(head == null){
                    return null;
                }
            }
        }
        while(head == null){
            return null;
        }
        ListNode curr = head;
        while(curr != null){
            while(curr.next != null && curr.next.val == val){
                curr.next = curr.next.next;
            }
            curr = curr.next;

        }
        return head;
    }
}