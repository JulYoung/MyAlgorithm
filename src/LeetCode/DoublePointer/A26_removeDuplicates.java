package LeetCode.DoublePointer;

import base.ListNode;

//  删除有序数组中的重复项，要求本地删除
public class A26_removeDuplicates {
    public static void main (String[] args) {

    }

    // 本地删除排序链表中的元素，使用双指针
    // 慢指针指向无重复的尾。
    // 快指针查找不等于慢指针的索引
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode slow = head; // 指向无重复的尾
        ListNode fast = head; // 查找
        while (fast != null) {
            if (fast.val != slow.val) {
                slow.next = fast;
                slow = slow.next;
            }
            fast = fast.next;
        }

        slow.next = null;
        return head;
    }

    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null) return null;
        ListNode slow = head; // 指向无重复的尾
        ListNode fast = head; // 查找
        while (fast.next != null) { // fast.next == null
            fast = fast.next;
            if (fast.val != slow.val) {
                slow.next = fast;
                slow = slow.next;
            }
        }
        slow.next = null;
        return head;
    }
}
