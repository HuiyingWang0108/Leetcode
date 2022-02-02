public class RemoveNthFromEnd {
    public static void main(String[] args) {
        RemoveNthFromEnd obj = new RemoveNthFromEnd();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        // head.next.next.next = new ListNode(4);
        // head.next.next.next.next = new ListNode(5);
        int n = 2;
        obj.removeNthFromEnd(head, n);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        /**
         * same to hasCycle
         * two pointers: slow and fast
         * 1 -> 2 -> 0 -> 6 ......-> 4 -> 7 -> 6 n = 2
         * ^ ^
         * | |
         * S<-- n -->F
         * 
         * pseudocode:
         * step1, let F = head
         * step2, while (n--) do
         * F = F.next
         * step3, let S = head
         * step4, while (F != null) do
         * S = S.next
         * F = F.next
         * end
         * step5, S.next = S.next.next
         * step6, quit
         * 
         */
        ListNode F = head;
        while (n-- > 0) {
            F = F.next;

        }
        if (F == null) {//[1, 2] n=2
            head = head.next;
            return head;
        }
        ListNode S = head;
        while (F != null && F.next != null) {
            F = F.next;
            S = S.next;
        }
        if (S.next == null) {//[1] n=1
            return null;
        }
        S.next = S.next.next;
        return head;
        // ListNode curr = head;
        // while(n > 0){
        // curr = curr.next;
        // if(curr == null){
        // head = head.next;
        // return head;
        // }
        // n--;
        // }
        // ListNode curr_n = curr;
        // curr = head;
        // while(curr != null){
        // if(curr_n.next == null){
        // curr.next = curr.next.next;
        // break;
        // }
        // curr = curr.next;
        // curr_n = curr_n.next;
        // }
        // return head;

    }
}