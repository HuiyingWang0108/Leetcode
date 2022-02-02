import java.util.Stack;

public class IsPalindrome3 {
    public static void main(String[] args) {
        IsPalindrome3 obj = new IsPalindrome3();
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
         * and put the 1st half in the stack
         * then compare the 1st half with the 2nd half
         */
        if (head.next == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        Stack<Integer> stack = new Stack<Integer>();
        while (slow != null && fast != null) {
            stack.add(slow.val);
            if (fast.next == null) {//link length is odd number
                stack.pop();
                fast = null;
            } else {
                fast = fast.next.next;
            }
            slow = slow.next;

        }
        // slow is the second half and reverse it
        //compare
        ListNode curr = slow;
        while(curr != null){//stack != null
            if(stack.pop() != curr.val){
                return false;
            }
            curr = curr.next;
        }
        return true;
    }

}