
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        // Early termination in case of null input or unilength list or rotation is zero
        if (head == null || head.next == null || k == 0)
            return head;

        // Step 1: Find the length and the tail node
        int length = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        // Step 2: Normalize k
        k = k % length;
        if (k == 0)
            return head;

        // Step 3: Make it a circular list
        tail.next = head;

        // Step 4: Find the new tail and new head
        int stepsToNewTail = length - k;
        ListNode newTail = head;
        for (int i = 1; i < stepsToNewTail; i++) {
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next;
        newTail.next = null; // break the circle

        return newHead;
    }
}