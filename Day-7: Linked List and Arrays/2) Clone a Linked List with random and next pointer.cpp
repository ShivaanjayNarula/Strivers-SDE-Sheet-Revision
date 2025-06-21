/*
// Definition for a Node.
class Node {
public:
    int val;
    Node* next;
    Node* random;
    
    Node(int _val) {
        val = _val;
        next = NULL;
        random = NULL;
    }
};
*/

class Solution {
public:
    Node* copyRandomList(Node* head) {
        unordered_map<Node*, Node*> mp;
        Node *ans = solve(head, mp);
        return ans;
    }
    Node *solve(Node *head, unordered_map<Node*, Node*> &mp)
    {
        if(head == nullptr)
        {
            return nullptr;
        }
        Node *temp = new Node(head->val);
        mp[head] = temp;
        temp->next = solve(head->next, mp);
        if(head->random)
        {
            temp->random = mp[head->random];
        }
        return temp;
    }
};
