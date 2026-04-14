/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        ListNode t1 = headA;
        ListNode t2 = headB;
        int Alen = 0, Blen = 0;

        while (t1 != null) {
            Alen++;
            t1 = t1.next;
        }

        while (t2 != null) {
            Blen++;
            t2 = t2.next;
        }
        int steps = Math.abs(Alen - Blen);

        if (Alen >= Blen)
            return collisionPoint(headA, headB, steps);
        else if (Blen > Alen)
            return collisionPoint(headB, headA, steps);

        return null;
    }

    ListNode collisionPoint(ListNode large, ListNode small, int steps) {
        while (steps > 0) {
            large = large.next;
            steps--;
        }
        while (large != null && small != null) {
            if (large == small)
                return large;
            large = large.next;
            small = small.next;
        }

        return null;
    }

}