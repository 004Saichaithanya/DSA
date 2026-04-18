/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if (head == null)
            return null;
        Stack<Node> stk = new Stack<>();
        Node temp = head;

        while (temp != null) {
            if (temp.child != null) {
                if (temp.next != null)
                    stk.push(temp.next);
                temp.next = temp.child;
                temp.child.prev = temp;
                temp.child = null;
            }
            temp = temp.next;
        }
        temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }
        // System.out.println(temp.val);

        while (!stk.isEmpty()) {
            Node top = stk.pop();
            temp.next = top;
            top.prev = temp;
            while (temp.next != null) {
                temp = temp.next;
            }
        }

        // for(Node x : stk)
        // System.out.println(x.val+" ");

        return head;
    }
}