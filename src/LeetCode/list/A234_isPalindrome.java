package LeetCode.list;

import base.ListNode;

// 判断是否是回文链表
public class A234_isPalindrome {
    public static void main(String[] args) {

    }

    // 判断一个字符串是否是回文串，可以用双指针，从前往后和从后往前判断。

    // 判断回文链表不能从后往前，因此,
    // 方法1：复制到一个数组，再使用双指针。空间复杂度O(n)
    // 方法2：递归。空间复杂度O(n)
    // 方法3：快慢指针 + 反转链表。
    public boolean isPalindrome(ListNode head) {

        ListNode slow, fast;
        slow = fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 若链表长度为奇数，fast指向末尾，slow在中位数
        // 若长度为偶数，fast指向null，slow在 n/2 + 1
        // 因此，若fast != null, 反转的起始点为slow.next

        if (fast != null) {
            slow = slow.next;
        }
        ListNode left = head;
        ListNode right = reverse(slow);

        while (right != null) {
            if (left.val != right.val) {
                return false;
            }
            left = left.next;
            right = right.next;
        }

        return true;
    }

    ListNode reverse(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = dummy.next;
            dummy.next = cur;
            cur = temp;
        }
        return dummy.next;
    }
}

