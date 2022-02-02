import java.util.ArrayList;
import java.util.List;
public class HasCycle{
    public static void main(String[] args){
        HasCycle obj = new HasCycle();
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next;
        boolean bl = obj.hasCycle(head);
        System.out.println("------bl----" + bl);
    }
    public boolean hasCycle(ListNode head) {
        int pos = -1;
        List<ListNode> nodeList = new ArrayList<ListNode>();
        while(head != null && !nodeList.contains(head)){
            nodeList.add(head);
            head = head.next;
        }
        pos = nodeList.indexOf(head);
       if(pos == -1){
           return false;
       }
        return true;
    }
}