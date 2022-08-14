package JianZhiOfferCoding;

// 快速幂运算
public class A22KthNodeFromEnd {
    public static void main(String[] args) {

    }

    static class Solution {
        public ListNode getKthFromEnd(ListNode head, int k) {
            if (head == null) {
                return null;
            }

            ListNode first = head;
            ListNode second = head;
            for (int i = 0; i < k-1; i++) {  // 前进k-1步
                first = first.next;
            }
            while (first.next != null) {
                first = first.next;
                second = second.next;
            }
            return second;
        }
    }

}
