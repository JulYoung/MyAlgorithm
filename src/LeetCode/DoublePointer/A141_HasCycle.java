package LeetCode.DoublePointer;

import base.ListNode;

// 链表有环问题，使用快慢指针
public class A141_HasCycle {

    public boolean hasCycle(ListNode head) {
        ListNode slow, fast;
        slow = fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
