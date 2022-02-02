public class DetectCycle{
    public static void main(String[] args) {
        /**
         * leetcode 142
         * 3 -> 2 -> 0 -> -4-|
         *      ^            |
         *      | ___________|
         * Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.
         * pseudocode:
         * step1, let fast pointer point to the head, let slow pointer point to the head 
         * step2, while (fast != null && fast.next != null) do
         *           slow = slow.next
         *           fast = fast.next.next
         *           if (slow == fast) then
         *              let slow = head
         *              while (slow != fast) do
         *                  slow = slow.next
         *                  fast = fast.next
         *              end
         *              return slow //fast == slow
         *        end
         * step3, quit
         */
        
    }
    public ListNode detectCycle(ListNode head) {
        ListNode F = head;
        ListNode S = head;
        while(F != null && F.next != null){
            S = S.next;
            F = F.next.next;
            if(F == S){
                S = head;
                while(F != S){
                    S = S.next;
                    F = F.next;
                }
                return S;
            }
        }
        return null;
    }
}