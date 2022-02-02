import java.util.ArrayList;
import java.util.List;

public class ReverseList{
    public static void main(String[] args){
        ReverseList obj = new ReverseList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        obj.reverseList(head);
    }
    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        List<ListNode> nodeList = new ArrayList<ListNode>();
        if(head == null){
            return null;
        }
        while(curr != null){
            nodeList.add(curr);
            curr = curr.next;
        }
        
        int n = nodeList.size() - 1;
        ListNode res = nodeList.get(n);
        ListNode temp = res;
        for(int i = n - 1; i >= 0; i--){
            temp.next = new ListNode();
            temp.next.val = nodeList.get(i).val;
            temp = temp.next;
        }
        return res;
    }
}