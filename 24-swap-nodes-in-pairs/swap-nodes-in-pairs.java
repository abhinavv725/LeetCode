class Solution {
    public ListNode swapPairs(ListNode head) {
        return reverseKGroup(head, 2);
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (!hasKNodes(head, k)) {
            return head; // Fewer than k nodes, return as-is
        }

        // Step 1: Save the (k+1)th node to reconnect after reversal
        ListNode nextGroupStart = getKthNode(head, k);

        // Step 2: Reverse first k nodes
        ListNode newHead = reverseFirstK(head, k);

        // Step 3: head is now the end of reversed group
        head.next = reverseKGroup(nextGroupStart, k);

        return newHead;
    }

    private boolean hasKNodes(ListNode node, int k) {
        int count = 0;
        while (node != null && count < k) {
            node = node.next;
            count++;
        }
        return count == k;
    }

    private ListNode reverseFirstK(ListNode head, int k) {
        ListNode prev = null;
        ListNode curr = head;
        for (int i = 0; i < k; i++) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev; // New head after reversal
    }

    private ListNode getKthNode(ListNode node, int k) {
        for (int i = 0; i < k && node != null; i++) {
            node = node.next;
        }
        return node;
    }
}
