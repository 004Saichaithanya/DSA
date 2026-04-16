/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;
        Node temp = head;
        //1.insert a copy node in middle
        while (temp != null) {
            Node copy = new Node(temp.val);
            copy.next = temp.next;
            temp.next = copy;
            temp = temp.next.next;
        }

        //2. connect the random pointer
        temp = head;
        while (temp != null) {
            Node copy = temp.next;
            if (temp.random != null)
                copy.random = temp.random.next;
            else
                copy.random = null;
            temp = temp.next.next;
        }
        //3.connect the next pointer
        Node dummy = new Node(-1);
        Node res = dummy;
        temp = head;

        while (temp != null) {
            res.next = temp.next;
            temp.next = temp.next.next;
            temp = temp.next;
            res = res.next;
        }

        return dummy.next;
    }
}