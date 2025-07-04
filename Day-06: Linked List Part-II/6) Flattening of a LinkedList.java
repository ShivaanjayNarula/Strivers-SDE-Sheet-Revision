class Solution {
    // Function to flatten a linked list
    Node flatten(Node root)
    {
        // code here
        if(root == null || root.next == null)
        {
            return root;
        }
        root.next = flatten(root.next);
        root = helper(root, root.next);
        return root;
    }
    Node helper(Node a, Node b)
    {
        if(a == null)
        {
            return b;
        }
        if(b == null)
        {
            return a;
        }
        Node result;
        if(a.data < b.data)
        {
            result = a;
            result.bottom = helper(a.bottom, b);
        }
        else
        {
            result = b;
            result.bottom = helper(a, b.bottom);
        }
        result.next = null;
        return result;
    }
}
