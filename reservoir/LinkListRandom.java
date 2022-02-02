
public class LinkListRandom {
    private ListNode head;

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);

    }

    public LinkListRandom(ListNode head) {
        this.head = head;
    }

    public int getRandom() {
        ListNode curr = head;
        int res = 0;
        int i = 1;
        while (curr != null) {
            Double random = Math.random();
            if (random <= 1.0 / i) {
                res = curr.val;
            }
            i++;
            curr = curr.next;
        }
        return res;
    }
}