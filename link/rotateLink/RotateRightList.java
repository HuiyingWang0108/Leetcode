public class RotateRightList {
    public static void main(String[] args) {
        RotateRightList obj = new RotateRightList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        int k = 2;
        obj.rotateRight(head, k);

    }

    public ListNode rotateRight(ListNode head, int k) {
        ListNode curr1 = head;
        int n = 0;
        while (curr1 != null) {
            n++;
            curr1 = curr1.next;
        }
        k = k % n;
        ListNode curr2 = head;
        int c = 1;
        while (c < n - k) {
            c++;
            curr2 = curr2.next;
        }
        ListNode temp = curr2.next;
        curr2.next = null;

        ListNode curr3 = temp;
        while (curr3.next != null) {
            curr3 = curr3.next;
        }
        curr3.next = head;
        return temp;

    }
}