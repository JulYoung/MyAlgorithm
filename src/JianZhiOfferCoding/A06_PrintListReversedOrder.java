package JianZhiOfferCoding;

import java.util.Arrays;
import java.util.Stack;

public class A06_PrintListReversedOrder {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        Solution solution = new Solution();
        ListNode list = solution.createList(arr);
        int[] res = solution.reversePrint(list);
        System.out.println(Arrays.toString(res));

    }


    // 链表结构
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    static class Solution {

        // 逆序打印
        public int[] reversePrint(ListNode head) {
            Stack<ListNode> st = new Stack<>();
            ListNode temp = head;
            while (temp != null) {
                st.push(temp);
                temp = temp.next;
            }
            int size = st.size();
            int[] res = new int[size];
            for (int i = 0; i < size; i++) {
                res[i] = st.pop().val;
            }
            return res;
        }

        // 创建链表
        public ListNode createList(int[] arr) {
            ListNode head = new ListNode(arr[0]);
            ListNode tail = head;
            for (int i = 1; i < arr.length; i++) {
                ListNode node = new ListNode(arr[i]);
                tail.next = node;
                tail = node;
            }
            return head;
        }
    }
}
