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
        Map<Node, Node> map = new HashMap<>();
        return clone(head, map);
    }
    public Node clone(Node head, Map<Node, Node> map)
    {
        if(head == null)
        {
            return null;
        }
        Node temp = new Node(head.val);
        map.put(head, temp);
        temp.next = clone(head.next, map);
        if(head.random != null)
        {
            temp.random = map.get(head.random);
        }
        return temp;
    }
}
