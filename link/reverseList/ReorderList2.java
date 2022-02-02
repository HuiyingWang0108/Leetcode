
public class ReorderList2 {
    public static void main(String[] args) {
        ReorderList2 obj = new ReorderList2();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        obj.reorderList(head);
    }

    public void reorderList(ListNode head) {
        /**
         * The number of nodes in the list is in the range [1, 5 * 104].
         * 1 <= Node.val <= 1000
         * >>>>>get new one reverse list and the list.size ××！！！
         * pseudocode
         * =====1======time complexity O(n), space complexity O(1)=========
         * 1, if list.size is 1 or 2
         *      then return list
         * 2, two pointer: one is list->next as p1, another one is list->next->next as p2
         * 3, while (p1 != null && p2->next != null) do
         *         p1 = p1->next
         *         if(p2->next->next == null) 
         *           then break
         *         p2 = p2->next->next
         *    end
         * 4, let p2 = p1->next, p2 is the second half of the list
         * 5, let p1->next = null, head is the first half of the list
         * 6, reverse p2
         * 7, merge head and p2
         */
        if (head.next == null || head.next.next == null) {
            return;
        }
        ListNode p1 = head;
        ListNode p2 = head;

        while(p1 != null && p2.next != null){
            p1 = p1.next;
            if(p2.next.next == null){
                break;
            }
            p2 = p2.next.next;
            

        }
        p2 = p1.next;
        p1.next = null;

        p2 = reverseList(p2);
        //merge head and p2
        ListNode curr = head;
        ListNode curr_p2 = p2;
        while(curr != null && curr_p2 != null){
            ListNode temp_curr = curr.next;
            ListNode temp_curr_p2 = curr_p2.next;
            curr.next = curr_p2;
            curr_p2.next = temp_curr;
            curr = temp_curr;
            curr_p2 = temp_curr_p2;
        }
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