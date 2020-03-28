import java.util.*;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class Plus {
    public ListNode plusAB(ListNode a, ListNode b) {
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        int x = 0;
        while (a != null || b != null || x != 0){
            int aVal = a != null ? a.val : 0;
            int bVal = b != null ? b.val : 0;
            int sum = aVal + bVal + x;
            int y = sum % 10;
            x = sum / 10;
            cur.next = new ListNode(y);
            cur = cur.next;

            a = a != null ? a.next : null;
            b = b != null ? b.next : null;
        }
        return head.next;
    }
}