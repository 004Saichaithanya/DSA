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
        if(headA == null || headB == null) return null;
        ListNode t1=headA;
        ListNode t2=headB;
        Set<ListNode> set=new HashSet<>();

        while(t1 != null){
            set.add(t1);
            t1=t1.next;
        }
        while(t2 != null){
            if(set.contains(t2))
                return t2;
            t2=t2.next;
        }

        return null;
    }
}