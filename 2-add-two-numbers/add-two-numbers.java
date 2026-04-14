/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        ListNode t1 = l1;
        ListNode t2 = l2;
        ListNode ans = new ListNode(-1);
        ListNode temp = ans;

        int carry = 0, s = 0;
        while (t1 != null || t2 != null) {
            int a = (t1 != null) ? t1.val : 0;
            int b = (t2 != null) ? t2.val : 0;
            s = a + b + carry;
            int d = s % 10;
            carry = s / 10;

            ListNode newNode = new ListNode(d);
            temp.next = newNode;
            temp = newNode;
            if (t1 != null)
                t1 = t1.next;
            if (t2 != null)
                t2 = t2.next;
        }
        //last carry
        if (carry != 0)
            temp.next = new ListNode(carry);

        return ans.next;

    }
}