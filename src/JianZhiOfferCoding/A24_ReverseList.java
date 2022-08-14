package JianZhiOfferCoding;

public class A24_ReverseList {
    public static void main(String[] args) {

    }

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode temp = null;
        while (cur != null) {
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
    public ListNode reverseList2(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = dummy.next;
            dummy.next = cur;
            cur = next;
        }
        return dummy.next;
    }
}
