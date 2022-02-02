
public class GetIntersectionNode2{
    public static void main(String[] args){
        GetIntersectionNode2 obj = new GetIntersectionNode2();
        ListNode tempHeadA = new ListNode(4);
        tempHeadA.next = new ListNode(1);
        tempHeadA.next.next = new ListNode(8);
        tempHeadA.next.next.next = new ListNode(4);
        tempHeadA.next.next.next.next = new ListNode(5);
        ListNode tempHeadB = new ListNode(5);
        tempHeadB.next = new ListNode(6);
        tempHeadB.next.next = new ListNode(1);
        tempHeadB.next.next.next = new ListNode(8);
        tempHeadB.next.next.next.next = new ListNode(4);
        tempHeadB.next.next.next.next.next = new ListNode(5);
        obj.getIntersectionNode(tempHeadA, tempHeadB);
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        /**
         * Time Complexity : O(m + n); 
         * Space Complexity : O(1)
         */
        ListNode tempHeadA = headA;
        ListNode tempHeadB = headB;
        int headA_l = 0;
        int headB_l = 0;
        while(tempHeadA != null){
            headA_l++;
            tempHeadA = tempHeadA.next;
        }
        while(tempHeadB != null){
            headB_l++;
            tempHeadB = tempHeadB.next;
        }
        int dif = Math.abs(headA_l - headB_l);
        if(headA_l > headB_l){
            while(dif != 0){
                dif--;
                headA = headA.next;
            }
        }else{
            while(dif != 0){
                dif--;
                headB = headB.next;
            }
        }
        while(headA != null && headB != null){
            if(headA == headB){
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }    
}