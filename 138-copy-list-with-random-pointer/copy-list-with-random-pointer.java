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
        HashMap<Node, Node> map = new HashMap<>();
        Node temp = head;

        while (temp != null) {
            Node copy = new Node(temp.val);
            map.put(temp, copy);
            temp = temp.next;
        }
        temp = head;
        while (temp != null) {
            Node copy = map.get(temp);
            copy.next = map.getOrDefault(temp.next, null);
            copy.random = map.getOrDefault(temp.random, null);
            temp = temp.next;
        }

        return map.get(head);
    }
}