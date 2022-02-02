import java.util.ArrayList;
import java.util.List;

public class GetIntersectionNode{
    public static void main(String[] args){
        GetIntersectionNode obj = new GetIntersectionNode();
        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = new ListNode(8);
        headA.next.next.next = new ListNode(4);
        headA.next.next.next.next = new ListNode(5);
        ListNode headB = new ListNode(5);
        headB.next = new ListNode(6);
        headB.next.next = new ListNode(1);
        headB.next.next.next = new ListNode(8);
        headB.next.next.next.next = new ListNode(4);
        headB.next.next.next.next.next = new ListNode(5);
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        /**
         * Time Complexity : O(m + n); 
         * Space Complexity : O(m)
         */
        if(headA == null || headB == null){
            return null;
        }
        if(headA == headB){
            return headA;
        }
        List<ListNode> nodeAList = new ArrayList<ListNode>();
        while(headA != null){
            nodeAList.add(headA);
            headA = headA.next;
        }
        while(headB != null){
            if(nodeAList.contains(headB)){
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }    
}