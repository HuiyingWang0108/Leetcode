public class MergeTwoLists{

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // ---------recursive-----------
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        // if(l1.val < l2.val){
        //     l1.next = mergeTwoLists(l1.next, l2);
        //     return l1;
        // }
        // l2.next = mergeTwoLists(l1, l2.next);
        // return l2;
        //------------ iteration: O(m + n)------------------
        ListNode head = new ListNode();
        ListNode curr = new ListNode();
        //who is the first ListNode
        if(l1.val < l2.val){
            head = l1;
            l1 = l1.next;
        }else{
            head = l2;
            l2 = l2.next;
        }
        curr = head;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                curr.next = l1;
                l1 = l1.next;
            }else{
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        if(l1 != null){
            curr.next = l1;
        }
        if(l2 != null){
            curr.next = l2;
        }
        return head;
    } 

    public static void main(String[] args){

        MergeTwoLists obj = new MergeTwoLists();

        //linklist [1, 3, 5]
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(5);
 
        //linklist [0, 2 ,4]
        ListNode l2 = new ListNode(0);
        l2.next = new ListNode(2);
        l2.next.next = new ListNode(4);
 
        ListNode l = obj.mergeTwoLists(l1, l2);
        System.out.println("----l---" + (l));
    }

}