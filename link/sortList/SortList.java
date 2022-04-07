public class SortList {
    /**leetcode 148 
     * Time: O(nlogn)
     * space: O(?)
    */
    public static void main(String[] args) {

    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = null;
        ListNode S = head;
        ListNode F = head;
        while (F != null && F.next != null) {
            temp = S;
            S = S.next;
            F = F.next.next;
        }
        temp.next = null;
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(S);
        return mergeList(l1, l2);
    }

    public ListNode mergeList(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val > l2.val) {
            l2.next = mergeList(l1, l2.next);
            return l2;
        } else {
            l1.next = mergeList(l1.next, l2);
            return l1;
        }
    }
}