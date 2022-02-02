public class IsPalindrome2{
    public static void main(String[] args) {
        IsPalindrome2 obj = new IsPalindrome2();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(1);
        obj.isPalindrome(head);

        
    }

    public boolean isPalindrome(ListNode head) {
        /**
         * first we are finding the middle of the linked list
         * then we are reversing 2nd half of the linked list
         * then we are equating the values from both halves of the list
         */
        if(head.next == null){
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode curr = head;
        while(slow != null && fast != null){
            slow = slow.next;
            if(fast.next == null){
                fast = null;
            }else{
                fast = fast.next.next;
            }
            
        }
        //slow is the second half and reverse it
        ListNode rev_sec = reverse(slow);
        while(rev_sec != null){
            if(curr.val != rev_sec.val){
                return false;
            }
            rev_sec = rev_sec.next;
            curr = curr.next;
        }

        return true;
    }

    private ListNode reverse(ListNode slow) {
        ListNode curr = slow.next;
        ListNode head = slow;
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