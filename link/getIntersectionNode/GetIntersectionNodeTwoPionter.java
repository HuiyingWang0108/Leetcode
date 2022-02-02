public class GetIntersectionNodeTwoPionter {
    public static void main(String[] args) {

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // leetcode 160
        /**
         * a + b - c := b + a -c
         */
        if (headA == headB) {
            return headA;
        }
        ListNode p1 = headA;
        ListNode p2 = headB;

        while (p1 != null || p2 != null) {
            if (p1 == null) {
                p1 = headB;
            }
            if (p2 == null) {
                p2 = headA;
            }
            if (p1 == p2) {
                return p1;
            }
            p1 = p1.next;
            p2 = p2.next;

        }
        return null;
    }
}