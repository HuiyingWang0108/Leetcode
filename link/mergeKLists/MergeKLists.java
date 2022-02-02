public class MergeKLists {
    public static void main(String[] args) {
        MergeKLists obj = new MergeKLists();
        // lists = [[1,4,5],[1,3,4],[2,6]]
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);
        ListNode[] lists = new ListNode[3];
        lists[0] = l1;
        lists[1] = l2;
        lists[2] = l3;
        ListNode res = obj.mergeKLists(lists);
        System.out.println(res.toString());
    }

    public ListNode mergeKLists(ListNode[] lists) {
        int k = lists.length;
        if (k == 0) {
            return null;
        }
        if (k == 1) {
            return lists[0];
        }

        while (k > 1) {
            int start = 0, end = k - 1;
            while (start < end) {
                lists[start] = merge(lists[start], lists[end]);
                start++;
                end--;
                if (start >= end) {
                    k = end + 1;
                }
            }
        }
        return lists[0];
    }

    public static ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head = new ListNode();
        if (l1.val < l2.val) {
            head = l1;
            head.next = merge(l1.next, l2);
        } else {
            head = l2;
            head.next = merge(l1, l2.next);
        }
        return head;
    }
}