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
    private ListNode reverse(ListNode head){
        ListNode prev = null;
        while(head!=null){
            ListNode temp = head.next;
            head.next=prev;
            prev=head;
            head=temp;
        }
        return prev;
    }
    public void reorderList(ListNode head) {
        ListNode slow=head, fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode secondHalf = slow.next;
        slow.next=null;
        secondHalf = reverse(secondHalf);
        ListNode firstHalf = head;
        
        while(secondHalf!=null){
            ListNode temp1 = firstHalf.next;
            ListNode temp2 = secondHalf.next;

            firstHalf.next=secondHalf;
            secondHalf.next=temp1;
            firstHalf=temp1;
            secondHalf=temp2;
        }

    }
}