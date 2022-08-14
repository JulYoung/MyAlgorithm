package JianZhiOfferCoding;

// 快速幂运算
public class A18_DeleteNodeInList {
    public static void main(String[] args) {


    }


    static class Solution {
        public ListNode deleteNode(ListNode head, int val) {
            if (head.val == val)
                return head.next;
            ListNode pre = head;
            ListNode cur = head.next;
            while (cur != null) {
                if (cur.val == val)
                    break;
                pre = cur;
                cur = cur.next;
            }
            if (cur != null)
                pre.next = cur.next;
            return head;
        }
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}