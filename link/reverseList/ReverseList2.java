
public class ReverseList2{
    public static void main(String[] args){
        ReverseList2 obj = new ReverseList2();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        obj.reverseList(head);
    }
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode curr = head.next;
        head.next = null;
        while(curr != null){
            ListNode temp = curr.next;
            curr.next = head;
            head = curr;
            curr = temp;
        }
        return head;
    }
}