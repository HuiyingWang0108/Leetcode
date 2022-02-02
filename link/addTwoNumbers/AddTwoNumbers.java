public class AddTwoNumbers {
    public static void main(String[] args) {
        AddTwoNumbers obj = new AddTwoNumbers();
        // linklist [2,4,9]
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);

        // linklist [5,6,4,9,2]
        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(9);
        l2.next.next.next  = new ListNode(9);
        l2.next.next.next.next = new ListNode(9);

        ListNode l = obj.addTwoNumbers(l1, l2);
        System.out.println("----l---" + (l));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp = new ListNode();
        ListNode curr = temp;
        int n = 0;
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + n;
            l1 = l1.next;
            l2 = l2.next;
            int m = sum % 10;
            if (sum < 10) {
                temp.val = sum;
                n = 0;
            } else {
                temp.val = m;
                n = sum / 10;
            }
            if (l1 != null || l2 != null) {
                temp.next = new ListNode();
                temp = temp.next;
            }
            if (l1 == null && l2 == null && n > 0) {
                temp.next = new ListNode();
                temp = temp.next;
                temp.val = n;
            }
        }
        while (l1 != null) {
            int sum = l1.val + n;
            l1 = l1.next;
            int m = sum % 10;
            if (sum < 10) {
                temp.val = sum;
                n = 0;
            } else {
                temp.val = m;
                n = sum / 10;
            }
            if (l1 != null) {
                temp.next = new ListNode();
                temp = temp.next;
            }else if(n > 0){
                temp.next = new ListNode();
                temp = temp.next;
                temp.val = n; 
            }
        }
        while (l2 != null) {
            int sum = l2.val + n;
            l2 = l2.next;
            int m = sum % 10;
            if (sum < 10) {
                temp.val = sum;
                n = 0;
            } else {
                temp.val = m;
                n = sum / 10;
            }
            if (l2 != null) {
                temp.next = new ListNode();
                temp = temp.next;
            }else if(n > 0){
                temp.next = new ListNode();
                temp = temp.next;
                temp.val = n; 
            }
        }
        return curr;
    }
}