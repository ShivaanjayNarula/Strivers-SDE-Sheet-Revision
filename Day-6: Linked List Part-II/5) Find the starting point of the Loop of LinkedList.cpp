/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode *detectCycle(ListNode *head) {
        if(head == nullptr || head->next == nullptr)
        {
            return nullptr;
        }
        ListNode *slow = head;
        ListNode *fast = head;
        ListNode *check = head;
        while(fast->next != nullptr && fast->next->next != nullptr)
        {
            slow = slow->next;
            fast = fast->next->next;
            if(slow == fast)
            {
                while(slow != check)
                {
                    slow = slow->next;
                    check = check->next;
                }
                return check;
            }
        }
        return nullptr;
    }
};
