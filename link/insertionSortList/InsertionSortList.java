public class InsertionSortList{
    public static void main(String[] args) {
        InsertionSortList obj = new InsertionSortList();
        ListNode head = new ListNode(6);
        head.next = new ListNode(5);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(1);
        head.next.next.next.next = new ListNode(8);
        head.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next.next = new ListNode(4);

        obj.insertionSortList(head);

        
    }
    public ListNode insertionSortList(ListNode head) {
        /**
         * 1 定义一个新的链表为null：第一次插入
         * 2 插入新的链表：最前边，中部，最后边
         */
        ListNode new_head = null;
        ListNode curr = head;
        while(curr != null){
            ListNode temp = curr.next;
            curr.next = null;
            if(new_head == null){
                new_head = curr;
                curr = temp;
            }else if(new_head.val >= curr.val){//the curr is the smallest of sorted nodes
                curr.next = new_head;
                new_head = curr;
                curr = temp;
            }
            else{
                ListNode curr_new_head = new_head;
                while(curr_new_head.next != null){
                    if(curr_new_head.val <= curr.val && curr_new_head.next.val > curr.val){//insert into the midle of sorted nodes
                        ListNode temp_new = curr_new_head.next;
                        curr_new_head.next = curr;
                        curr.next = temp_new;
                        curr = temp;
                        break;
                    }
                    curr_new_head = curr_new_head.next;
                }
                if(curr_new_head.next == null){//the largest one in sorted nodes <= curr.val
                    curr_new_head.next = curr;
                    curr = temp;
                }
            }
            
        }
        return new_head;

    }
}