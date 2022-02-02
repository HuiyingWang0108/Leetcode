public class IsPalindrome{
    public static void main(String[] args) {
        IsPalindrome obj = new IsPalindrome();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        obj.isPalindrome(head);

        
    }

    public boolean isPalindrome(ListNode head) {
        if(head.next == null){
            return true;
        }
        ListNode curr = head;
        StringBuffer s = new StringBuffer();
        while(curr != null){
            s.append(curr.val);
            curr = curr.next;
        }
        StringBuffer rs = new StringBuffer(s).reverse();
        if(s.toString().equals(rs.toString())){
            return true;
        }else
            return false;
    }
    
}