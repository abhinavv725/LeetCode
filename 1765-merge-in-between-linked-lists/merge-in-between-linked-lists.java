/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        // Dummy node simplifies edge cases (e.g., a = 0)
        ListNode dummy = new ListNode(0);
        dummy.next = list1;

        ListNode prevA = dummy;

        // Step 1: Move to the node just before index 'a'
        for (int i = 0; i < a; i++) {
            prevA = prevA.next;
        }

        // Step 2: Move to the node just after index 'b'
        ListNode curr = prevA;
        for (int i = 0; i <= b - a + 1; i++) {
            curr = curr.next;
        }

        // Step 3: Connect node before 'a' to head of list2
        prevA.next = list2;

        // Step 4: Traverse list2 to its tail
        ListNode tail2 = list2;
        while (tail2.next != null) {
            tail2 = tail2.next;
        }

        // Step 5: Connect tail of list2 to the node after 'b'
        tail2.next = curr;

        // Return the modified list1 (starting from dummy.next)
        return dummy.next;
    }
}