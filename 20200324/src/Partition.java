import java.util.*;
/*题目：

        编写代码，以给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的结点之前
        给定一个链表的头指针 ListNode* pHead，请返回重新排列后的链表的头指针。注意：分割以后保持原来的数据顺序不变。

        思路：
        创建两个新链表，将原来的链表的值和x进行比较，
        比x小的采用尾插法插入到新链表1中，比x大的也采用尾插法插入到新链表2中，比较完原链表所有的节点后，将链表1和链表2拼接在一起。链表1在前，链表2在后。
*/

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class Partition {
    public ListNode partition(ListNode pHead, int x) {
        if (pHead == null){
            return null;
        }else if (pHead.next == null){
            return pHead;
        }
        ListNode smallHead = new ListNode(0);
        ListNode small = smallHead;
        ListNode largeHead = new ListNode(0);
        ListNode large = largeHead;
        while (pHead != null){
            if (pHead.val < x){
                small.next = pHead;
                small = small.next;
            }else {
                large.next = pHead;
                large = large.next;
            }
            pHead = pHead.next;
        }
        large.next = null;
        small.next = largeHead.next;
        return smallHead.next;
    }
}