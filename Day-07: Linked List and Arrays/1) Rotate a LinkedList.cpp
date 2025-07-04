/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* rotateRight(ListNode* head, int k) {
        ListNode *temp = head;
        if(head == nullptr || head->next == nullptr)
        {
            return head;
        }
        int n = 1;
        while(temp->next != nullptr)
        {
            temp = temp->next;
            n++;
        }
        temp->next = head;
        temp = head;
        for(int i = 0; i < n - (k % n) - 1; i++)
        {
            temp = temp->next;
        }
        head = temp->next;
        temp->next = nullptr;
        return head;
    }
};
