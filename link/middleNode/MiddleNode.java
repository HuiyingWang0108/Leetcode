public class MiddleNode{
    public static void main(String[] args) {
        
    }
    public ListNode middleNode(ListNode head) {
        /**leetcode 876 */
        ListNode F = head;
        ListNode S = head;
        while(F != null && F.next != null){
            F = F.next.next;
            S = S.next;
        }
        return S;
    }
}