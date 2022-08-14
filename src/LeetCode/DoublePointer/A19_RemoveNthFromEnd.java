package LeetCode.DoublePointer;

import base.ListNode;

// 链表有环问题，使用快慢指针
public class A19_RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast, slow;
        slow = fast = dummy;

        while (n != 0) {
            fast = fast.next;
            n--;
        }

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return dummy.next;
    }
}
