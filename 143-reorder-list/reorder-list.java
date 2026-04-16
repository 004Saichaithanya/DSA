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
    public void reorderList(ListNode head) {
        Stack<ListNode> stk = new Stack<>();

        ListNode temp = head;

        while (temp != null) {
            stk.push(temp);
            temp = temp.next;
        }
        temp = head;
        ListNode top = head;

        while (!stk.isEmpty()) {
            top = stk.pop();
            if (top != temp && temp.next != top) {
                ListNode front = temp.next;
                temp.next = top;
                top.next = front;
                temp = front;
            } else
                break;
        }

        if (top == temp)
            temp.next = null;
        else if (temp.next == top)
            top.next = null;

    }
}