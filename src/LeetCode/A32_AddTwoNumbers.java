package LeetCode;

public class A32_AddTwoNumbers {
    public static void main(String[] args) {
        Solution solution = new Solution();

    }

    static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            if (l1 == null && l2 == null) return null;

            ListNode res = new ListNode();

            ListNode cur1 = l1;
            ListNode cur2 = l2;
            ListNode cur3 = res;

            int carry = 0;

            while (cur1 != null || cur2 != null) {

                int a = cur1 != null ? cur1.val : 0;
                int b = cur2 != null ? cur2.val : 0;

                int temp = (a + b + carry) % 10;
                carry = (a + b + carry) > 9 ? 1 : 0;

                cur3.next = new ListNode(temp);

                if (cur1 != null) cur1 = cur1.next;
                if (cur2 != null) cur2 = cur2.next;
                cur3 = cur3.next;
            }
            if (carry != 0) {
                cur3.next = new ListNode(carry);
            }
            return res.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
