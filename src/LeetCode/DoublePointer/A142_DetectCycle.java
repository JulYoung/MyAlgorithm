package LeetCode.DoublePointer;

import base.ListNode;

// 链表有环问题，使用快慢指针, 找环的起点
public class A142_DetectCycle {


    public ListNode detectCycle(ListNode head) {
        ListNode slow, fast;
        slow = fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        // 此时，slow走了k步，fast走了2k步。因此环的大小为k。
        // 设slow反向距环起点为m，链表起点距离环起点为k-m。
        // 此时，slow距环起点也是k-m
        ListNode temp = head;
        while (temp != slow) {
            temp = temp.next;
            slow = slow.next;
        }
        return slow;
    }
}
