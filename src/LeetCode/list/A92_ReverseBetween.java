package LeetCode.list;

import base.ListNode;

// 反转部分链表
public class A92_ReverseBetween {


    static class Solution {
        public ListNode reverseBetween(ListNode head, int left, int right) {
            // 定义假头结点，方便处理
            ListNode dummyHead = new ListNode(0);
            dummyHead.next = head;

            // 初始化指针
            ListNode pre = dummyHead;
            ListNode cur = dummyHead.next;

            // 移动到指定位置
            for (int i = 0; i < left - 1; i++) {
                pre = pre.next;
                cur = cur.next;
            }

            // 头插法
            for (int i = 0; i < right - left; i++) {
                ListNode removed = cur.next;
                cur.next = removed.next;

                removed.next = pre.next;
                pre.next = removed;
            }
            return dummyHead.next;
        }
    }
}

