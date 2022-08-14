package LeetCode.list;

import base.ListNode;

public class A25_reverseKGroup {
    public static void main(String[] args) {
    }


    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;  // 反转段的前一个节点
        ListNode end = dummy;  // 反转段的最后一个节点

        while (end.next != null) {
            // end向后移动n次
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }

            if (end == null) {
                break;  // 剩下的链表个数不足k个，退出
            }

            ListNode start = pre.next; // 反转开始节点
            ListNode next = end.next;  // 记录末尾的下一个节点

            end.next = null;  //

            pre.next = reverse(start); // 反转，返回头结点

            start.next = next;

            // 重置初始状态
            pre = start;
            end = pre;
        }
        return dummy.next;
    }

    // 反转链表 -
    public ListNode reverse(ListNode start) {
        ListNode pre = null;
        ListNode cur = start;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    // 反转链表 - 头插
    public ListNode reverseByHeadInsert(ListNode start) {
        ListNode dummy = new ListNode(0);
        dummy.next = null;

        ListNode cur = start;

        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = dummy.next;
            dummy.next = cur;
            cur = temp;
        }

        return dummy.next;
    }
}

