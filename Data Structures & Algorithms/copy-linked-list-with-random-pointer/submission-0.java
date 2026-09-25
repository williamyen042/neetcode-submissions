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
        
        Node temp = head;
        Map<Node, Node> saved = new HashMap<>();
        while(temp != null) {
            Node deep = new Node(temp.val);
            saved.put(temp, deep);
            temp = temp.next;
        }
        temp = head;
        while(temp != null) {
            Node savedNode = saved.get(temp);
            savedNode.next = saved.get(temp.next);
            savedNode.random = saved.get(temp.random);
            temp = temp.next;
        }
        temp = head;
        return saved.get(temp);
    }
}
