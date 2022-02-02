public class HasCycle2{
    public static void main(String[] args){
        HasCycle2 obj = new HasCycle2();
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next;
        boolean bl = obj.hasCycle(head);
        System.out.println("------bl----" + bl);
    }
    public boolean hasCycle(ListNode head) {
        ListNode F = head;
        ListNode S = head;
        while(F != null && F.next != null){
            S = S.next;
            F = F.next.next;
            if(S == F){
                return true;
            }
        }
        return false;
        // ListNode nodeFast = head;
        // ListNode nodeSlow = head;
        // while(head == null || head.next == null){
        //     return false;
        // }
        // while(nodeFast != null && nodeFast.next.next != null){
        //     nodeFast = nodeFast.next.next;
        //     nodeSlow = nodeSlow.next;
        //     if(nodeSlow == nodeFast){
        //         return true;
        //     }
        // }
        // return false;
    }
}