/* Node structure  used in the program

struct Node{
    int data;
    struct Node * next;
    struct Node * bottom;

    Node(int x){
        data = x;
        next = NULL;
        bottom = NULL;
    }

};
*/

class Solution {
  public:
    // Function which returns the  root of the flattened linked list.
    Node *flatten(Node *root) {
        // Your code here
        if(root == nullptr || root->next == nullptr)
        {
            return root;
        }
        root->next = flatten(root->next);
        root = helper(root, root->next);
        return root;
    }
    Node *helper(Node *a, Node *b)
    {
        if (a == nullptr)
        {
            return b;
        }
        if(b == nullptr)
        {
            return a;
        }
        Node* ans;
        if(a->data < b->data)
        {
            ans = a;
            ans->bottom = helper(a->bottom, b);
        }
        else
        {
            ans = b;
            ans->bottom = helper(a, b->bottom);
        }
        ans->next = nullptr;
        return ans;
    }
};
