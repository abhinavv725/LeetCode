class Solution {
    /**
     * Time Complexity: O(L) - where L is the length of the linked list. We traverse it once.
     * Space Complexity: O(1) - We only use two constant-space pointers.
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Create a dummy node to handle edge cases like removing the head
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode fast = dummy;
        ListNode slow = dummy;

        // Move fast pointer n+1 steps ahead so there's a gap of n nodes between fast and slow
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // Move both pointers until fast reaches the end
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // slow.next is the nth node from the end; skip it
        slow.next = slow.next.next;

        // Return the actual head (which might have changed)
        return dummy.next;
    }
}