import java.util.ArrayList;
import java.util.List;

public class ReorderList {
    public static void main(String[] args) {
        ReorderList obj = new ReorderList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        obj.reorderList(head);
    }

    public void reorderList(ListNode head) {
        /**
         * The number of nodes in the list is in the range [1, 5 * 104].
         * 1 <= Node.val <= 1000
         * >>>>>get new one reverse list and the list.size ××！！！
         * pseudocode
         * =====1======time complexity O(n), space complexity O(n)=========
         * 1, if list.size is 1 or 2
         * then return list
         * 2, iteration list and save it in an array arr
         * 3, two pointer point to the arr: one is point to the left, another one is
         * point to the right
         * 4, while (left < right) do
         * list->val = arr[left]
         * list.next->val = arr[right]
         * left++
         * right--
         * if (left == right)
         * then list.next.next->val = arr[left]
         * break
         * list = list->next->next
         * end
         * 
         */
        if (head.next == null || head.next.next == null) {
            return;
        }
        ListNode curr_1 = head;
        List<Integer> list = new ArrayList<Integer>();
        while (curr_1 != null) {
            list.add(curr_1.val);
            curr_1 = curr_1.next;
        }
        int left = 0, right = list.size() - 1;
        ListNode curr_2 = head;
        while (left < right) {
            curr_2.val = list.get(left);
            curr_2.next.val = list.get(right);
            left++;
            right--;
            if (left == right) {
                curr_2.next.next.val = list.get(left);
                break;
            }
            curr_2 = curr_2.next.next;
        }
    }
}